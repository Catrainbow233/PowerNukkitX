package cn.nukkit.entity.ai.memory;

import cn.nukkit.api.PowerNukkitXOnly;
import cn.nukkit.api.Since;
import cn.nukkit.math.Vector3;
import lombok.Getter;
import lombok.Setter;

/**
 * MoveDirectionMemory用于存储实体的寻路过程中的某一时刻的目标移动方向
 */
@PowerNukkitXOnly
@Since("1.6.0.0-PNX")
@Getter
@Setter
public class MoveDirectionMemory extends Vector3Memory {

    protected Vector3 start;
    protected Vector3 end;

    public MoveDirectionMemory() {
        super(null);
    }

    /**
     * @param start 方向向量起点
     * @param end   方向向量终点
     */
    public MoveDirectionMemory(Vector3 start, Vector3 end) {
        //构建方向向量
        super(start != null && end != null ? new Vector3(end.x - start.x, end.y - start.y, end.z - start.z) : null);
        this.start = start;
        this.end = end;
    }

    public void updateDirection(){
        setData(new Vector3(end.x - start.x, end.y - start.y, end.z - start.z));
    }
}
