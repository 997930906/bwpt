package bwpt.test.Test;

import redis.clients.jedis.Jedis;
import org.junit.Before;
import org.junit.Test;
public class TestRedis {
	private Jedis jedis;

    // beforeע��ķ�����������testע��ķ���֮ǰ������
    @Before
    public void setup() {
        // ����redis������
        jedis = new Jedis("localhost", 6379);
        System.out.println("Connection to server sucessfully");
        // ����һ��Key����Ƿ����ӳɹ�
        // jedis.set("foo", "bar");
        // String value = jedis.get("foo");
        // System.out.println("foo-->"+value);
        // �鿴�����Ƿ�����
        System.out.println("Server is running: " + jedis.ping());//���PONG�����ӳɹ�
        System.out.println("--------------------------------------------");
    }
    
    /**
     * jedis�洢�ַ���
     */
    @Test
    public void testString() {
        // -----�������----------
        jedis.set("name", "xinxin");// ��key-->name�з�����value-->xinxin
        System.out.println(jedis.get("name"));// ִ�н����xinxin

        jedis.append("name", " is my lover"); // ƴ�� ��
                                                // �����redis��������key��Ӧ��ֵ�ǲ����пո��Ŷ
        System.out.println(jedis.get("name"));

        jedis.del("name"); // ɾ��ĳ����
        System.out.println(jedis.get("name"));
        // ���ö����ֵ��
        jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");
        jedis.incr("age"); // ���м�1����
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-"
                + jedis.get("qq"));

        jedis.set("china", "���Ǹ�����ֵ");
    }
}
