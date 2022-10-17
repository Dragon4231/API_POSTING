package com.example.task3.readers;

import com.example.task3.data.LoginUser;
import com.example.task3.data.Posting;
import lombok.extern.java.Log;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCsv {
    private ArrayList<LoginUser> loginUserArrayList = new ArrayList<>();
    private ArrayList<Posting> postingArrayList = new ArrayList<>();

    public ArrayList<LoginUser> getLoginsFromCsv() throws IOException {
        Resource resource = new ClassPathResource("logins.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()));
        String line;
        Scanner scanner;
        line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            LoginUser loginUser = new LoginUser();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            loginUser.setApplication(scanner.next().trim());
            loginUser.setAppAccountName(scanner.next().trim());
            String temp = scanner.next();
            temp = temp.trim();
            temp = temp.toLowerCase();
            if (temp.equals("true")) loginUser.setActive(true);
            else loginUser.setActive(false);
            loginUser.setJobTitle(scanner.next().trim());
            loginUser.setDepartment(scanner.next().trim());
            loginUserArrayList.add(loginUser);
        }
        bufferedReader.close();
        return loginUserArrayList;
    }

    public ArrayList<Posting> getPostingsFromCsv() throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Resource resource = new ClassPathResource("postings.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()));
        String line;
        Scanner scanner;
        line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            if (line.isEmpty()) continue;
            Posting posting = new Posting();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            posting.setNumber(scanner.next().trim());
            posting.setItem(Integer.parseInt(scanner.next().trim()));
            posting.setDate(format.parse(scanner.next().trim()));
            posting.setPostingDate(format.parse(scanner.next().trim()));
            posting.setMaterialDescription(scanner.next().trim());
            posting.setQuantity(Integer.parseInt(scanner.next().trim()));
            posting.setBUn(scanner.next().trim());
            posting.setAmount(Double.parseDouble(scanner.next().trim().replaceAll(",", "\\.")));
            posting.setVal(scanner.next().trim());
            String name = scanner.next().trim();
            posting.setAuthorityPosting(isAuthority(name));
            posting.setUserName(name);
            postingArrayList.add(posting);
        }
        bufferedReader.close();
        return postingArrayList;
    }

    private boolean isAuthority(String name) {
        for (LoginUser l : loginUserArrayList) {
            if (l.isActive() && l.getAppAccountName().equals(name)) {
                return true;
            }
        }
        return false;
    }


}
