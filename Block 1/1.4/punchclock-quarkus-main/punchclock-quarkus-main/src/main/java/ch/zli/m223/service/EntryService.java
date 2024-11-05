package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }

    public Entry findById(Long id) {
        return entityManager.find(Entry.class, id);
    }

    @Transactional
    public void deleteEntry(Long id) {
        var entry = entityManager.find(Entry.class, id);
        if (entry == null) {
            return;
        }
        entityManager.remove(entry);
    }

    @Transactional
    public Entry updateEntry(Long id, Entry updatedEntry) {
        var entry = entityManager.find(Entry.class, id);
        if (entry == null) {
            return null;
        }
        entry.setCheckIn(updatedEntry.getCheckIn());
        entry.setCheckOut(updatedEntry.getCheckOut());
        entityManager.merge(entry);
        return entry;
    }
}