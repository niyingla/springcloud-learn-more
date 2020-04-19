package com.imooc.hystrix.show.command;

import com.netflix.hystrix.*;
import org.assertj.core.util.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 一旦满足合并时间窗口周期大小，Hystrix会进行一次批量提交，进行一次依赖服务的调用（减少握手次数），
 * 通过充写HystrixCollapser父类的mapResponseToRequests方法，将批量返回的请求分发到具体的每次请求中。
 * 优点 降低多次服务间http请求握手时间
 * 缺点 但是很少有机会时间足够近内产生多次http请求
 * @author : jiangzh
 * @program : com.imooc.hystrix.show.command
 * @description : 请求合并处理对象
 **/
public class CommandCollapser extends HystrixCollapser<List<String>, String , Integer> {

    private Integer id;

    public CommandCollapser(Integer id){
        super(Setter
                .withCollapserKey(HystrixCollapserKey.Factory.asKey("CommandCollapser"))
                .andCollapserPropertiesDefaults(
                        HystrixCollapserProperties.defaultSetter()
                                //超时时间 批处理创建到处理的毫秒数
                                .withTimerDelayInMilliseconds(1000)
                )
        );
        //设置请求id
        this.id = id;
    }
    /**
    * @Description: 获取请求参数
    * @Param: []
    * @return: java.lang.Integer
    * @Author: jiangzh
    */
    @Override
    public Integer getRequestArgument() {
        return id;
    }

    /**
    * @Description: 批量业务处理
    * @Param: [collection]
    * @return: com.netflix.hystrix.HystrixCommand<java.util.List<java.lang.String>>
    * @Author: jiangzh
    */
    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, Integer>> collection) {
        return new BatchCommand(collection);
    }

    /**
    * @Description: 批量处理结果与请求业务之间映射关系处理
    * @Param: [strings 结果列表, collection 请求集合]
    * @return: void
    * @Author: jiangzh
    */
    @Override
    protected void mapResponseToRequests(List<String> strings, Collection<CollapsedRequest<String, Integer>> collection) {
        int counts = 0;
        Iterator<HystrixCollapser.CollapsedRequest<String, Integer>> iterator = collection.iterator();
        //循环响应请求
        while (iterator.hasNext()) {
            //迭代返回结果
            HystrixCollapser.CollapsedRequest<String, Integer> response = iterator.next();

            String result = strings.get(counts++);

            response.setResponse(result);
        }
    }
}


/**
 * 创建批量请求
 */
class BatchCommand extends HystrixCommand<List<String>>{

    /**
     * 设置请求listRequest为入参
     */
    private Collection<HystrixCollapser.CollapsedRequest<String, Integer>> collection;

    public BatchCommand(Collection<HystrixCollapser.CollapsedRequest<String, Integer>> collection){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("BatchCommand")));
        this.collection = collection;
    }

    @Override
    protected List<String> run() throws Exception {
        //每次执行请求打印
        System.err.println("currentThread : "+Thread.currentThread().getName());
        List<String> result = Lists.newArrayList();

        //循环批量请求
        Iterator<HystrixCollapser.CollapsedRequest<String, Integer>> iterator = collection.iterator();
        //挨个处理业务逻辑
        while (iterator.hasNext()) {
            HystrixCollapser.CollapsedRequest<String, Integer> request = iterator.next();

            Integer reqParam = request.getArgument();

            // 具体业务逻辑
            result.add("Mooc req: "+ reqParam);
        }
        //响应结果数组
        return result;
    }
}
