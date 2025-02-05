package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUser(User user, Pageable pageable);

    // SELECT p.id, p.title, p.product_id, p.folder_id
    // FROM product p left join product_folder pf on p.id = pf.product_id
    // WHERE p.user_id = 1 and pf.folder_id = 3;
    // ODER BY p.id desc;
    // LIMIT 10, 10; // LIMIT 0, 10;
    Page<Product> findAllByUserAndProductFolderList_FolderId(User user, Long folderId, Pageable pageable);



}
