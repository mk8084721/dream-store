package com.trachcode.dreamstore.repository;

import com.trachcode.dreamstore.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image , Long> {
}
