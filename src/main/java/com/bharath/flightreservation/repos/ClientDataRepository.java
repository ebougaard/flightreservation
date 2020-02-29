package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDataRepository extends JpaRepository<ClientData,String>{


    @Query("select reference,count(reference) from ClientData WHERE reference !=null group by reference")
    public List<Object[]> findTypeReferenceCount();

}


