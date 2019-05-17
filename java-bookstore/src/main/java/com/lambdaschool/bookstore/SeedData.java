package com.lambdaschool.bookstore;

import com.lambdaschool.bookstore.model.*;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.repository.RoleRepository;
import com.lambdaschool.bookstore.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    AuthorRepository authorRepos;
    BookRepository bookRepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, AuthorRepository authorRepos, BookRepository bookRepos) {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.authorRepos = authorRepos;
        this.bookRepos = bookRepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = rolerepos.save(r1);
        r2 = rolerepos.save(r2);
        r3 = rolerepos.save(r3);

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> data = new ArrayList<>();
        data.add(new UserRoles(new User(), r2));
        data.add(new UserRoles(new User(), r3));


        User u1 = new User("gw", "admin", users);
        User u2 = new User("admin", "password", admins);
        User u3 = new User("cinnamon", "123456", data);
        userrepos.save(u1);
        userrepos.save(u2);
        userrepos.save(u3);


        Author a1 = new Author("Musk", "Elon");
        Author a2 = new Author("Jobs", "Steve");
        Author a3 = new Author("Gates", "Bill");
        authorRepos.save(a1);
        authorRepos.save(a2);
        authorRepos.save(a3);


        Book b1 = new Book("GoodBook","13214", 1);
        Book b2 = new Book("BadBook", "6969", 2);
        Book b3 = new Book("Don't Read This Book", "12354", 234);
        bookRepos.save(b1);
        bookRepos.save(b2);
        bookRepos.save(b3);
    }
}
