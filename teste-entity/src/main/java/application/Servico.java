/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.TypedQuery;

/**
 *
 * @author arthu
 */

public class Servico {
    public static void main(String[] args) {
        
        InputStream inputStream = Servico.class.getClassLoader().getResourceAsStream("teste-planilha.csv");
        
        Set<String> newEntries = new HashSet<>();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            
            String line;
            br.readLine();
            
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] vect = line.split(";");

               if (vect.length >= 2) {
                    String cList = vect[0].trim();
                    String description = vect[1].trim();

                    if (!cList.isEmpty() && !description.isEmpty()) {
                        newEntries.add(cList + "," + description);
                    }
                }
            }
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            
            try {
                tx.begin();
                TypedQuery<Data> query = em.createQuery("SELECT d FROM Data d", Data.class);
                List<Data> allData = query.getResultList();
                
                for (Data existingData : allData) {
                    String existingEntry = existingData.getCList() + "," + existingData.getDescription();
                    if (!newEntries.contains(existingEntry)) {
                        em.remove(existingData);
                    }
                }
                
                allData = query.getResultList();
                
                for (String entry : newEntries) {
                    String[] parts = entry.split(",", 2);
                    String cList = parts[0];
                    String description = parts[1];
                    
                    boolean exists = false;
                    
                    for (Data existingData : allData) {
                        if (existingData.getCList().equals(cList) && existingData.getDescription().equals(description)) {
                            exists = true;
                            break;
                        }
                    }
                    
                    if (!exists) {
                        Data newData = new Data(cList, description);
                        em.persist(newData);
                    }
                }
                
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
                System.out.println("Erro ao persistir dados: " + e.getMessage());
            } finally {
                em.close();
                emf.close();
            }

            System.out.println("DATA:");
            for (String entry : newEntries) {
                System.out.println(entry);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}