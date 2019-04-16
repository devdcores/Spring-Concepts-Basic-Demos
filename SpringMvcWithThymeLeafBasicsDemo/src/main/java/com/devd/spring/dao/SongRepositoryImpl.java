package com.devd.spring.dao;

import com.devd.spring.entity.Song;
import com.devd.spring.exception.SongIdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
@Slf4j
public class SongRepositoryImpl implements SongRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Song getSongById(UUID songId) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();

        CriteriaQuery<Song> criteria = builder.createQuery(Song.class);
        Root<Song> root = criteria.from(Song.class);
        Song song;
        try {
            criteria.select(root).where(builder.equal(root.get("songId"), songId));

            Query<Song> q = currentSession.createQuery(criteria);
            song = q.getSingleResult();
        } catch (Exception e) {
            log.error("Exception : "+e.getMessage());
            throw new SongIdNotFoundException("SongId doesn't exist!!");
        }

        return song;
    }

    @Override
    public String saveSong(Song song) {
        Session currentSession = sessionFactory.getCurrentSession();
        UUID d = (UUID) currentSession.save(song);
        return d.toString();
    }

    public List<Song> getAllSongs() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();

        CriteriaQuery<Song> criteria = builder.createQuery(Song.class);
        criteria.from(Song.class);

        return currentSession.createQuery(criteria).list();
    }

    @Override
    public void deleteSongById(Song song) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(song);
    }

    @Override
    public void updateSong(Song song) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(song);
    }
}
