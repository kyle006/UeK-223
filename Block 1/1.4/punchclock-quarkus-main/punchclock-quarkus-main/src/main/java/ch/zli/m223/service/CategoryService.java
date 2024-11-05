package ch.zli.m223.service;

import ch.zli.m223.model.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Category createCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    public List<Category> findAll() {
        var query = entityManager.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }

    @Transactional
    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Transactional
    public void deleteCategory(Long id) {
        var category = entityManager.find(Category.class, id);
        if (category == null) {
            return;
        }
        entityManager.remove(category);
    }

    @Transactional
    public Category updateCategory(Long id, Category updatedCategory) {
        var category = entityManager.find(Category.class, id);
        if (category == null) {
            return null;
        }
        category.setTitle(updatedCategory.getTitle());
        entityManager.merge(category);
        return category;
    }
}