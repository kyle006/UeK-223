package ch.zli.m223.service;

import ch.zli.m223.model.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tag createTag(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    public List<Tag> findAll() {
        var query = entityManager.createQuery("FROM Tag", Tag.class);
        return query.getResultList();
    }

    @Transactional
    public Tag findById(Long id) {
        return entityManager.find(Tag.class, id);
    }

    @Transactional
    public void deleteTag(Long id) {
        var tag = entityManager.find(Tag.class, id);
        if (tag == null) {
            return;
        }
        entityManager.remove(tag);
    }

    @Transactional
    public Tag updateTag(Long id, Tag updatedTag) {
        var tag = entityManager.find(Tag.class, id);
        if (tag == null) {
            return null;
        }
        tag.setTitle(updatedTag.getTitle());
        entityManager.merge(tag);
        return tag;
    }
}