package com.zy.tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Redis {
	Jedis jedis;
	JedisPoolConfig config = new JedisPoolConfig();
	JedisPool pool;
	public Redis() {
		config.setMaxTotal(30);
		config.setMaxIdle(15);
		pool = new JedisPool(config, "localhost",6379);
	}
	
	public void save(String key,String value) {
		try {
			jedis = null;
			jedis = pool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}
}
