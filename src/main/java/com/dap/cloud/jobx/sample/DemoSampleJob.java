package com.dap.cloud.jobx.sample;

import com.dap.cloud.jobx.api.ShardingContext;
import com.dap.cloud.jobx.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DemoSampleJob implements SimpleJob  {

    private final Logger logger = LoggerFactory.getLogger(DemoSampleJob.class);

    /**
     * @author:hanhang
     * @date:2024/9/26  17:41
     * @method:preProcess: 作业统一前处理方法；作业维度的方法；（如果要执行，需在作业配置上开启统一前处理逻辑）
     * @param shardingContext
     * @class:com.dap.cloud.jobx.sample.DemoSampleJob2
     * @return:boolean
    */
    public boolean preProcess(ShardingContext shardingContext) {
        // 统一前置处理中可以自定义作业运行时的参数传递
        shardingContext.setDefaultParamValue("defineKey","test");
        return true;
    }

    /**
     * @author:hanhang
     * @date:2024/9/26  17:37
     * @method:beforeJob: 作业分片前处理方法，作业分片执行开始前执行
     * @param shardingContext
     * @class:com.dap.cloud.jobx.sample.DemoSampleJob
     * @return:boolean
     */
    @Override
    public boolean beforeJob(ShardingContext shardingContext) {
        logger.debug("作业" + shardingContext.getJobName() + "执行前检查前置执行条件");
        return true;
    }

    /**
     * @author:hanhang
     * @date:2024/9/26  17:38
     * @method:execute: 作业分片处理方法，作业分片执行的逻辑；重点业务逻辑实现方法
     * @param shardingContext
     * @class:com.dap.cloud.jobx.sample.DemoSampleJob
     * @return:boolean
     */
    @Override
    public boolean execute(ShardingContext shardingContext) {
        logger.debug("作业" + shardingContext.getJobName() + "处理逻辑");
        return true;
    }

    /**
     * @author:hanhang
     * @date:2024/9/26  17:39
     * @method:afterJob: 作业分片后处理方法，作业分片执行开始后执行
     * @param shardingContext
     * @class:com.dap.cloud.jobx.sample.DemoSampleJob
     * @return:boolean
     */
    @Override
    public boolean afterJob(ShardingContext shardingContext) {
        logger.debug("作业" + shardingContext.getJobName() + "执行后置处理");
        return true;
    }

    /**
     * @author:hanhang
     * @date:2024/9/26  17:40
     * @method:postProcess: 作业统一后处理方法；作业维度的方法；（如果要执行，需在作业配置上开启统一后处理逻辑）
     * @param shardingContext
     * @class:com.dap.cloud.jobx.sample.DemoSampleJob2
     * @return:boolean
    */
    public boolean postProcess(ShardingContext shardingContext) {
        return true;
    }
}
