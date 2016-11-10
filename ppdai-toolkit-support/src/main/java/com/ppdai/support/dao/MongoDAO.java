package com.ppdai.support.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDAO {
  
	@Autowired
	protected MongoTemplate mongoTemplate;

	// 按类查询指定集合是否存在
	public boolean exists(Class<?> clazz) {
		return mongoTemplate.collectionExists(clazz);
	}

	// 按集合名字查询集合是否存在
	public boolean exists(String collectionName) {
		return mongoTemplate.collectionExists(collectionName);
	}

	// 按指定条件查询对象是否存在
	// Query构建举例：Query query = new Query(Criteria.where("_id").is(1l));
	// Update构建举例：Update.update("status", 1)
	// 注意使用org.springframework.data.mongodb.core.query下面的Criteria,Query和Update
	public boolean exists(Query query, Class<?> clazz) {
		return mongoTemplate.exists(query, clazz);
	}

	// 从指定集合从按一定条件查询对象是否存在
	public boolean exists(Query query, String collectionName) {
		return mongoTemplate.exists(query, collectionName);
	}

	public boolean exists(Query query, Class<?> clazz, String collectionName) {
		return mongoTemplate.exists(query, clazz, collectionName);
	}

	// 保存对象
	public void save(Object object) {
		mongoTemplate.insert(object);
	}

	// 保存对象到指定集合
	public void save(Object object, String collectionName) {
		mongoTemplate.insert(object, collectionName);
	}

	// 删除对象
	public void delete(Object object) {
		mongoTemplate.remove(object);
	}

	// 从指定集合删除对象
	public void delete(Object object, String collectionName) {
		mongoTemplate.remove(object, collectionName);
	}

	// 通过条件查询更新数据
	public void update(Query query, Update update, Class<?> clazz) {
		mongoTemplate.updateMulti(query, update, clazz);
	}

	// 通过条件查询实体(集合)
	public List<Object> find(Query query, Class<Object> clazz) {
		return mongoTemplate.find(query, clazz);
	}

	// 通过ID获取记录,并且指定了集合名(表的意思)
	public Object get(String id, String collectionName) {
		return mongoTemplate.findById(id, Object.class, collectionName);
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
}