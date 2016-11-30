package net.multicolorworld;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HogeRepository extends JpaRepository<Hoge, Integer> {

    @Query("select hoge.id from Hoge hoge")
    public List<Hoge> findAllOnlyId();
}
