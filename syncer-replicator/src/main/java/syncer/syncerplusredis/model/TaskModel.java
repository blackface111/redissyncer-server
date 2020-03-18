package syncer.syncerplusredis.model;

import lombok.*;

/**
 * @author zhanenqiang
 * @Description 描述
 * @Date 2020/3/10
 */
@Getter
@Setter
@Builder
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class TaskModel {

    /**
     * 任务Id
     */
    private String id;
    /**
     * 任务组Id
     */
    private String groupId;
    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 源RedisUri
     */
    private String sourceRedisAddress;

    /**
     * 源Redis密码
     */
    private String sourcePassword;

    /**
     * 目标RedisUri
     */
    private String targetRedisAddress;

    /**
     * 目标Redis密码
     */
    private String targetPassword;

    /**
     * 文件地址
     */
    private String fileAddress;

    /**
     * 创建任务时是否自动启动
     */
    private boolean autostart;

    /**
     * 进入增量状态后已有OffSet
     * 重新启动时从头开始为 true 续传为false
     */
    private boolean afresh;

    /**
     * 批次大小 默认为 1500
     */
    private Integer batchSize;

    /**
     *任务类型
     * default total   1  全量＋增量
     *  stockonly      2  全量
     *  incrementonly  3  增量
     */
    @Builder.Default
    private Integer tasktype=1;

    /**
     *增量模式下从缓冲区开始同步的位置
     * 默认为 endbuffer 缓冲区尾
     *
     * "endbuffer"    1
     * "beginbuffer"  2
     *
     */
    @Builder.Default
    private Integer offsetPlace=1;

    /**
     * 任务反馈信息
     */
    @Builder.Default
    private String taskMsg="";

    /**
     * offset地址
     */
    @Builder.Default
    private Long offset=-1L;

    /**
     * 任务状态
     *
     * CREATING,CREATE,RUN,STOP,PAUSE,BROKEN
     *
     *  STOP        0      停止
     *  CREATING    1      创建中
     *  CREATE      2      创建完成（完成任务信息校验进入启动阶段）
     *  RUN         3      任务启动完成，进入运行状态
     *  PAUSE       4      任务暂停
     *  BROKEN      5      任务因异常停止
     *  RDBRUNING   6      全量任务进行中
     *  COMMANDRUNING 7    增量任务进行中
     */
    @Builder.Default
    private Integer status=0;




    /**
     * redis版本
     */
    private  double redisVersion;

    /**
     * rdb版本
     */
    @Builder.Default
    private Integer rdbVersion=6;


    /**
     * 数据同步类型  ---->SyncType
     * 1 sync
     * 2 rdb
     * 3 aof
     * 4 mixed
     * 5 onlineRdb
     * 6 onlineAof
     * 7 onlineMixed
     * 8 commandDumpUp
     */
    @Builder.Default
    private Integer syncType=1;



    /**
     * 源Redis类型  RedisBranchType
     * 1 单机
     * 2 cluster
     * 3 file
     * 4 哨兵
     */
    @Builder.Default
    private Integer sourceRedisType=1;

    /**
     * 目标Redis类型
     * 1 单机
     * 2 cluster
     * 3 file
     */
    @Builder.Default
    private Integer targetRedisType=1;



    public String getSourceUri(){
        return baseRedisUri(getSourceRedisAddress());
    }

    public String getTargetUri(){
        return baseRedisUri(getTargetRedisAddress());
    }

    String baseRedisUri(String uri){

        return "";
    }

}
