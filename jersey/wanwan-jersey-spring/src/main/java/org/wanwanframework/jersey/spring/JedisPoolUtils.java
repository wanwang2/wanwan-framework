package org.wanwanframework.jersey.spring;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {
    
    public static JedisPoolConfig c = new JedisPoolConfig(); // ���ӳ�����
    public static JedisPool jedisPool = null; // ���ӳ�
    
    static {
        c.setBlockWhenExhausted(true); // ���Ӻľ�������
        c.setLifo(true); // ����ȳ�
        c.setMaxIdle(10); // ������������Ϊ10
        c.setMinIdle(0); // ��С����������Ϊ0
        c.setMaxTotal(20); // ���������Ϊ20
        c.setMaxWaitMillis(-1); // �������ȴ���������������
        c.setMinEvictableIdleTimeMillis(1800000); // ������ӵ���С����ʱ�䣺30����
        c.setTestOnBorrow(true); // ��ȡ����ʱ�Ƿ������ӵ���Ч�ԣ���
        c.setTestWhileIdle(true); // ����ʱ�Ƿ������ӵ���Ч�ԣ���
        
        jedisPool = new JedisPool(c, "192.168.0.111", 6379); // ��ʼ�����ӳ�
    }
    
    /**
     * ��ȡJedis����
     * @return Jedis����
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
    
    public static void main(String[] args) {
        /* ����Redis */
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedis();
            jedis.set("myname", "Nick Huang");
            String rs = jedis.get("myname");
            System.out.println(rs);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

}