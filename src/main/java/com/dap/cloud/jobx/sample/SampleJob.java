package com.dap.cloud.jobx.sample;

import com.dap.cloud.jobx.api.ShardingContext;
import com.dap.cloud.jobx.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SampleJob implements SimpleJob  {

    private final Logger logger = LoggerFactory.getLogger(DemoSampleJob.class);


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
        logger.debug("作业" + shardingContext.getJobName() + "作业分片前处理方法");
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

}
