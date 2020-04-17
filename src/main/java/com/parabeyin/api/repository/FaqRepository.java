package com.parabeyin.api.repository;
/* Created by Farhad on 2020-04-15 */

import com.parabeyin.api.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {

    List<Faq> findByActive(boolean active);
}
