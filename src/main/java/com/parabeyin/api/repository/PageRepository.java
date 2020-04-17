package com.parabeyin.api.repository;
/* Created by Farhad on 2020-04-15 */

import com.parabeyin.api.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    Page findBySlugAndActive(String slug, boolean active);
}
