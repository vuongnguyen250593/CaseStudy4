package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Like;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ILikeRepository extends JpaRepository<Like, Long> {

    @Query("select l from Like l where l.statusLike.s_id  = 1 and l.user.id = :idUser")
    Iterable<Like> findLikesByUser_Id (long idUser);


    @Query("SELECT l FROM Like  l WHERE l.product.id = :idProduct AND l.user.id = :idUser")
    Optional<Like> findLikeByProductAndUser(long idProduct, long idUser);

    @Modifying
    @Transactional
    @Query("UPDATE Like l SET l.statusLike.s_id = 1 WHERE l.product.id = :idProduct AND l.user.id = :idUser")
    Like save1ByProductAndUser(long idProduct, long idUser);

    @Modifying
    @Transactional
    @Query("UPDATE Like l SET l.statusLike.s_id = 2 WHERE l.product.id = :idProduct AND l.user.id = :idUser")
    Like save2ByProductAndUser(long idProduct, long idUser);
}
