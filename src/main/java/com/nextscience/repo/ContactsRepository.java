package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextscience.entity.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Integer> {

}
