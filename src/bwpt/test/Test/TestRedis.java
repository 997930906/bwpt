package bwpt.test.Test;

import redis.clients.jedis.Jedis;
import org.junit.Before;
import org.junit.Test;
public class TestRedis {
	private Jedis jedis;

    // before注解的方法，在运行test注解的方法之前会运行
    @Before
    public void setup() {
        // 连接redis服务器
        jedis = new Jedis("localhost", 6379);
        System.out.println("Connection to server sucessfully");
        // 增加一个Key检测是否连接成功
        // jedis.set("foo", "bar");
        // String value = jedis.get("foo");
        // System.out.println("foo-->"+value);
        // 查看服务是否运行
        System.out.println("Server is running: " + jedis.ping());//输出PONG则连接成功
        System.out.println("--------------------------------------------");
    }
    
    /**
     * jedis存储字符串
     */
    @Test
    public void testString() {
        // -----添加数据----------
        jedis.set("name", "xinxin");// 向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));// 执行结果：xinxin

        jedis.append("name", " is my lover"); // 拼接 。
                                                // 如果用redis命令输入key对应的值是不能有空格的哦
        System.out.println(jedis.get("name"));

        jedis.del("name"); // 删除某个键
        System.out.println(jedis.get("name"));
        // 设置多个键值对
        jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");
        jedis.incr("age"); // 进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-"
                + jedis.get("qq"));

        jedis.set("china", "这是个中文值");
    }
}
