package com.cyh.hibernate.repository;

import com.cyh.hibernate.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

/**
 * @author yunhai.chen
 * @date 2018/11/26 20:31<br>
 * Description:
 **/
@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public List<User> findUser() {
        String hql = "FROM USER_INFO AS userinfo";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    public void deleteByName(String name) {
        User byName = getByName(name);
        if(Objects.nonNull(byName)) {
            entityManager.remove(findUser());
        }
    }

    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public User getByName(String name) {
        String hql = "FROM USER_INFO WHERE NAME = ?";
        List<User> resultList = entityManager.createQuery(hql).setParameter(0, name).getResultList();
        if(!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }
}
