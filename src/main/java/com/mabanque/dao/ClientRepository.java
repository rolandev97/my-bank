package com.mabanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mabanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>
{

}