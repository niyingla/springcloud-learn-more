package com.imooc.hystrix.show.command;

import com.netflix.hystrix.*;
import lombok.Data;

/**
 * Command 测试demo 隔离线程 执行一次
 * 隔离模式
 * THREAD 线程（新的线程执行业务） 通过设置线程池大小来控制并发访问量，
 * 当线程饱和的时候可以拒绝服务，防止依赖问题扩散,服务间调用推荐线程隔离
 * SEMAPHORE 信号量（简单理解为计数器 当前线程直接执行业务）推荐内部隔离
 * @author : jiangzh
 * @program : com.imooc.hystrix.show.command
 * @description :
 **/
@Data
public class CommandDemo extends HystrixCommand<String> {

    private String name;

    public CommandDemo(String name){
        super(Setter
                //groupKey 分组监控和报警也是线程池默认名称
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandHelloWorld"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.defaultSetter()
                        .withRequestCacheEnabled(false) // 请求缓存开关)
                        // 切换线程池隔离还是信号量隔离
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        //信号量最大请求值
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(2)
                        //失败最大请求数
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(10)
//                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                        // .withCircuitBreakerForceOpen(true) // 强制开启熔断器
                        .withCircuitBreakerRequestVolumeThreshold(2) // 单位时间内的请求阈值
                        .withCircuitBreakerErrorThresholdPercentage(50) // 当满足请求阈值时，超过50%则开启熔断
        //设置线程池名字
        ).andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("MyThreadPool"))
//         .andThreadPoolPropertiesDefaults(
//                 HystrixThreadPoolProperties.defaultSetter()
//                    .withCoreSize(2) //核心线程数
//                    .withMaximumSize(3) //线程池最大数量
//                    .withAllowMaximumSizeToDivergeFromCoreSize(true) //匹配上条配置 是否开启最大线程数
//                    .withMaxQueueSize(2) //等待队列数量   等待时间+执行时间 执行完毕不能超出超时时间（默认 1s）
//         )
        );

        this.name = name;
    }


    /**
    * @Description: 0个影片信息
    * @Param: []
    * @return: java.lang.String
    * @Author: jiangzh
    */
    @Override
    protected String getFallback() {
        String result = "Fallback name : "+ name;

        System.err.println(result+" , currentThread-"+Thread.currentThread().getName());

        return result;
    }

    /**
    * @Description:  影厅新增查询影片信息
    * @Param:
    * @return: java.lang.String
    * @Author: jiangzh
    */
    // 单次请求调用的业务方法
    @Override
    protected String run() throws Exception {
        String result = "CommandHelloWorld name : "+ name;

//        Thread.sleep(800l);

        if(name.startsWith("jiangzh")){
            int i = 6/0;
        }

        System.err.println(result+" , currentThread-"+Thread.currentThread().getName());

        return result;
    }


    /**
     * 复写当前方法  造成相同name获得相同缓存key 触发缓存
     * @return
     */
    @Override
    protected String getCacheKey() {
        return String.valueOf(name);
    }
}
