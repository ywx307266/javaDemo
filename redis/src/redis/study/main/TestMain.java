package redis.study.main;

import java.util.*;

import redis.clients.jedis.Jedis;
import redis.entity.People;
import redis.util.RedisUtil;
import redis.util.SerializeUtil;

public class TestMain
{
	public static void main(String[] args) {
		Jedis client=null;
		try
		{
		   client = RedisUtil.getJedis();
			// savePeopleInfo(client);
			// Map<String,String> info=client.hgetAll("basicInfo");
			// System.out.println(info);
			// savePeopleList(client);
			Map<byte[], byte[]> perList = client.hgetAll("perList".getBytes());
			for (byte[] key : perList.keySet())
			{
				System.out.println(String.format("key:%s ,%s", new String(key),
						SerializeUtil.unserialize(perList.get(key), People.class).toString()));
			}
			System.out.println("Main function sleep 6s!");
			Thread.sleep(6000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			RedisUtil.returnResource(client);
		}

		System.out.println("Main function run over!");
	}

	/**
	 * ����HashMap<String,String>��Ϣ
	 * 
	 * @param client
	 */
	private static void savePeopleInfo(Jedis client) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("name", "������");
		info.put("age", "25");
		info.put("address", "����ʡ�����и�������կ·����9#704");
		info.put("telephone", "18710711009");
		client.hmset("basicInfo", info);
		info = client.hgetAll("basicInfo");
	}

	/**
	 * ����HashMap<String,People>��Ϣ
	 * 
	 * @param client
	 */
	private static void savePeopleList(Jedis client) {
		Map<byte[], byte[]> perList = new HashMap<byte[], byte[]>();
		People person = new People("0001", "����", new Date());
		perList.put(person.getPerId().getBytes(), SerializeUtil.serialize(person));

		person = new People("0002", "Ԭ��", new Date());
		perList.put(person.getPerId().getBytes(), SerializeUtil.serialize(person));

		person = new People("0003", "�ĳ�", new Date());
		perList.put(person.getPerId().getBytes(), SerializeUtil.serialize(person));

		client.hmset("perList".getBytes(), perList);
	}
}
