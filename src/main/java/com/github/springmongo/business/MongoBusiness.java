package com.github.springmongo.business;

import com.github.springmongo.dao.*;
import com.github.springmongo.entities.*;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
@Service
public class MongoBusiness {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    SocietyRepository societyRepository;

    @Autowired
    CityRepository cityRepository;

    User user;
    Book book;
    Author author;

    Employee employee;
    Department department;
    Direction direction;
    Society society;
    HashMap<String, Employee> employees;
    HashMap<String, Department> departments;
    HashMap<String, Direction> directions;

    City city;
    Country country;

    @PostConstruct
    public void init(){
        deleteAllUsersBdd();

        for(int i=1; i<50; i++) {
            user = new User();
            user.setUsername("user."+i);
            user.setName("user"+i);
            user.setPassword("password"+i);
            user.setCreatedDate(new Date());
            saveUserBdd(user);
        }
        System.out.println("");
        System.out.println("****** simple spring data find query ******");
        System.out.println("----- simple find ");
        System.out.println(userRepository.findByName("user1"));
        System.out.println("----- simple count ");
        System.out.println(userRepository.countByName("user1"));
        System.out.println("----- find users with paging ");
        System.out.println(userRepository.findUsersPaging(0,5,"user"));
        System.out.println("*******************************************");
        System.out.println("");
        System.out.println("****** spring data find query with @Query with exclude field ******");
        System.out.println(userRepository.findByNameAndUsernameExcludePassWord("user2", "user.2"));
        System.out.println("*******************************************");
        System.out.println("");

        deleteAllAuthorsBdd();

        book = new Book();
        book.setName("book1");
        saveBookBdd(book);

        author = new Author();
        author.setName("author1");
        author.setBook(book);
        saveAuthorBdd(author);

        book = new Book();
        book.setName("book2");
        saveBookBdd(book);

        author = new Author();
        author.setName("author2");
        author.setBook(book);
        saveAuthorBdd(author);

        System.out.println("****** join DBRef ******");
        System.out.println(authorRepository.findOneByName("author1"));
        System.out.println("*******************************************");
        System.out.println("");
        deleteAllSocietiesBdd();

        employees = new HashMap<>();
        departments = new HashMap<>();
        directions = new HashMap<>();

        employee = new Employee();
        employee.setName("employee11");
        employees.put("employee11",employee);

        department = new Department();
        department.setName("department11");
        department.setEmployees(employees);
        departments.put("department11",department);

        direction = new Direction();
        direction.setName("direction11");
        direction.setDepartments(departments);
        directions.put("direction11",direction);


        society = new Society();
        society.setName("society1");
        society.setDirections(directions);

        saveSocietyBdd(society);

        employees = new HashMap<>();
        departments = new HashMap<>();
        directions = new HashMap<>();

        employee = new Employee();
        employee.setName("employee21");
        employees.put("employee21",employee);

        employee = new Employee();
        employee.setName("employee22");
        employees.put("employee22",employee);

        department = new Department();
        department.setName("department21");
        department.setEmployees(employees);
        departments.put("department21",department);

        employee = new Employee();
        employee.setName("employee31");
        employees = new HashMap<>();
        employees.put("employee31",employee);

        employee = new Employee();
        employee.setName("employee32");
        employees.put("employee32",employee);

        department = new Department();
        department.setName("department22");
        department.setEmployees(employees);
        departments = new HashMap<>();
        departments.put("department22",department);

        employee = new Employee();
        employee.setName("employee41");
        employees = new HashMap<>();
        employees.put("employee41",employee);

        employee = new Employee();
        employee.setName("employee42");
        employees.put("employee42",employee);

        department = new Department();
        department.setName("department23");
        department.setEmployees(employees);
        departments = new HashMap<>();
        departments.put("department23",department);

        direction = new Direction();
        direction.setName("direction21");
        direction.setDepartments(departments);
        directions.put("direction21",direction);

        society = new Society();
        society.setName("society2");
        society.setDirections(directions);

        saveSocietyBdd(society);

        System.out.println("****** hierarchical structure HashMap ******");
        employee = new Employee();
        employee.setName("employee43");
        societyRepository.addUpdateEmployee("society2", "direction21","department23", "employee43", employee,"society");
        System.out.println("----------- add employee43 ");
        System.out.println(societyRepository.findSociety("society2"));

        employee = new Employee();
        employee.setName("employee53");
        societyRepository.addUpdateEmployee("society2", "direction21","department23", "employee43", employee,"society");
        System.out.println("----------- update employee43 to employee53");
        System.out.println(societyRepository.findSociety("society2"));

        societyRepository.deleteEmployee("society2", "direction21","department23", "employee41", employee,"society");
        System.out.println("----------- delete employee41 ");
        System.out.println(societyRepository.findSociety("society2"));
        System.out.println("*******************************************");
        System.out.println("");
        System.out.println("****** hierarchical structure Object ******");

        deleteAllCitiesBdd();

        country = new Country();
        country.setName("Algeria");
        city = new City();
        city.setName("Algiers");
        city.setCountry(country);
        city.setArea(363);
        city.setPopulation(3154792);
        saveCityBdd(city);

        city = new City();
        city.setName("constantine");
        city.setCountry(country);
        city.setArea(2288);
        city.setPopulation(464219);

        saveCityBdd(city);

        country = new Country();
        country.setName("tunisia");
        city = new City();
        city.setName("Sousse");
        city.setCountry(country);
        city.setArea(45);
        city.setPopulation(674971);

        saveCityBdd(city);

        System.out.println(cityRepository.findCityByCountry("Algeria", "city"));
        System.out.println("*******************************************");
        System.out.println("");

        System.out.println("****** dynamic query ******");
        System.out.println(cityRepository.findCityDynamicQuery(3000000, 300, "city"));
        System.out.println("*******************************************");
        System.out.println("");
    }

    @Transactional
    public void deleteAllSocietiesBdd(){
        societyRepository.deleteAll();
    }

    @Transactional
    public void deleteAllUsersBdd(){
        userRepository.deleteAll();
    }

    @Transactional
    public void saveUserBdd(User user){
        userRepository.save(user);
    }

    @Transactional
    public void deleteAllAuthorsBdd(){
        authorRepository.deleteAll();
    }

    @Transactional
    public void saveAuthorBdd(Author author){
        authorRepository.save(author);
    }

    @Transactional
    public void saveBookBdd(Book book){
        bookRepository.save(book);
    }

    @Transactional
    public void saveSocietyBdd(Society society){
        societyRepository.save(society);
    }

    @Transactional
    public void saveCityBdd(City city){
        cityRepository.save(city);
    }

    @Transactional
    public void deleteAllCitiesBdd(){
        cityRepository.deleteAll();
    }
}
