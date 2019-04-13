package com.devd.spring.dao;

import com.devd.spring.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SongRepositoryImpl implements SongRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public void addSong(Song song) {
        sessionFactory.getCurrentSession().save(song);
    }


    public List<Song> getAllSongs() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();

        CriteriaQuery<Song> criteria = builder.createQuery(Song.class);
        criteria.from(Song.class);

        return currentSession.createQuery(criteria).list();
    }
}
