package bwpt.test.Test;

import java.util.List;

import redis.clients.jedis.Jedis;
public class RedisListTest {  
	 public static void main(String[] args) {
		Jedis jedis = new Jedis("115.159.66.245", 8605 );
         //Jedis jedis = new Jedis("192.168.0.100", 8605 );
      //   Jedis jedis = new Jedis("125.220.159.160", 8605 );
         jedis.auth("admin@b605"); 
         jedis.set("DB726.DBX16724.4", "2018-01-01 12:12:12 , 78.3");
         jedis.set("DB726.DBX16724.4", "2018-01-01 12:12:13 , 78.9");
         //jedis.set("key2", "jedis qq");
         String string = jedis.get("DB726.DBX16724.4");
         System.out.println(string);
         System.out.println(jedis.ping());
         jedis.quit();
	 }  
}