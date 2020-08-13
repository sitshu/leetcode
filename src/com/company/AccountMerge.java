package com.company;

import java.util.*;
import java.util.stream.Stream;

public class AccountMerge {

    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>();
        String[][] strings = {{"David","David0@m.co","David1@m.co"},{"David","David3@m.co","David4@m.co"},{"David","David4@m.co","David5@m.co"},{"David","David2@m.co","David3@m.co"}};
    }
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, List<TreeSet<String>>> nameToEmail = new HashMap<>();
            List<List<String>> result = new ArrayList<>();
            for(List<String> list : accounts){
                String name = list.get(0);
                List emails = list.subList(1, list.size());
                if(nameToEmail.containsKey(name)){
                    if(!checkPerson(nameToEmail.get(name), emails)){
                        TreeSet<String> newSet = new TreeSet<>();
                        newSet.addAll(emails);
                        nameToEmail.get(name).add(newSet);
                    }
                } else {
                    TreeSet<String> newSet = new TreeSet<>();
                    newSet.addAll(emails);
                    List<TreeSet<String>> sets = new ArrayList<>();
                    sets.add(newSet);
                    nameToEmail.put(name,  sets);
                }
            }

            for(Map.Entry<String, List<TreeSet<String>>> entry: nameToEmail.entrySet()){
                String name = entry.getKey();
                List<TreeSet<String>> emails = entry.getValue();
                for(TreeSet<String> email: emails){
                    List<String> person = new ArrayList<>();
                    person.add(name);
                    person.addAll(email);
                    result.add(person);
                }
            }
            return result;
        }

        public boolean checkPerson (List<TreeSet<String>> sets, List<String> emails){
            Set<String> emailSet = new HashSet<>(emails);

            Set<String> collection = new HashSet<>();
         //   Stream.of(sets).forEach(collection::addAll);
//
//            for(TreeSet<String> treeset: sets){
//                if(!Collections.disjoint(emailSet, treeset)){
//                    treeset.addAll(emailSet);
//                    return true;
//                }
//            }

            return false;
        }

}
