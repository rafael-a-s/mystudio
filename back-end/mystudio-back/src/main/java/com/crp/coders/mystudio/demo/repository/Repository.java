package com.crp.coders.mystudio.demo.repository;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;

import com.crp.coders.mystudio.demo.model.DefaultEntity;
import com.crp.coders.mystudio.demo.util.JPAUtil;
import com.crp.coders.mystudio.demo.util.RepositoryException;
import com.crp.coders.mystudio.demo.util.VersionException;

public class Repository<T extends DefaultEntity> {

    private EntityManager entityManager;

    public Repository(){
        super();
        setEntityManager(JPAUtil.getEntityManager());
    }


    public T save(T entity) throws RepositoryException, VersionException{
       
        try {
            getEntityManager().getTransaction().begin();
            entity = getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
            return entity;
        } catch (OptimisticLockException e) {
           // excecao do @version
			System.out.println("Problema com o controle de concorrencia.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new VersionException("As informações estão antigas, dê um refresh.");
        } catch(Exception e){
            System.out.println("Problema ao executar o save.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RepositoryException("Problema ao salvar.");
        }
    }

    public void save(T... entitys) throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
			for (T entity : entitys) {
				getEntityManager().merge(entity);
			}
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Problema ao executar o save.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RepositoryException("Problema ao salvar.");
		}
	}

    public void remove(T entity) throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
			T obj = getEntityManager().merge(entity);
			getEntityManager().remove(obj);
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Problema ao executar o remove.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RepositoryException("Problema ao remover.");
		}
	}

    public T findById(int id) throws RepositoryException {
		try {
		final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		Class<T> tClass = (Class<T>) (type).getActualTypeArguments()[0];
		
		T t = (T) getEntityManager().find(tClass, id);
		return t;
		}catch(Exception e){
			System.out.println("Erro no find.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao buscar os dados");
		}
		
	}

    

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    
}
