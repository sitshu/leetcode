package com.company.amazon;

import java.util.*;

public class WebsiteVisitPattern {


   static class Event
    {
        public String user;
        public String website;
        public int timestamp;

        public Event(String username, String website, int timestamp) {
            this.user = username;
            this.website = website;
            this.timestamp = timestamp;
        }
    }


    public static void main(String[] args) {


        String[] user = {"u1","u1","u1","u2","u2","u2"};
        String[] websites = {"a","b","a","a","b","c"};
        int[] timestamp = {1,2,3,4,5,6};

        String res = "/a/b/c";
        String[] re = res.split("/");
       // List<String> res = mostVisitedPattern(user, timestamp, websites);
        return;

    }
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        List<Event> eventList = new ArrayList<>();
        for(int i = 0; i<username.length; i++) {
            Event event = new Event(username[i], website[i], timestamp[i]);
            eventList.add(event);
        }

        Collections.sort(eventList, (v1, v2) -> v1.timestamp -v2.timestamp);
        Map<String, List<String>> userToWebsiteMap = new HashMap<>();
        for(Event event: eventList) {
            List<String> websites = userToWebsiteMap.getOrDefault(event.user, new ArrayList<>());
            websites.add(event.website);
            userToWebsiteMap.put(event.user, websites);
        }


        Map<String, Integer> sequenceToFrequencyMap = new HashMap<>();
        for(List<String> websites: userToWebsiteMap.values()){
            if(websites.size() < 3) continue;
            Set<String> sequences = getAllSequencesFromList(websites);
            for(String sequence: sequences) {
                sequenceToFrequencyMap.put(sequence, sequenceToFrequencyMap.getOrDefault(sequence, 0)+1);
            }
        }

        int max = 0;
        String res = "";
        for(Map.Entry<String, Integer> entry: sequenceToFrequencyMap.entrySet()){

            if(max<entry.getValue()){
                max = entry.getValue();
                res = entry.getKey();
            } else if(max == entry.getValue() ) {
                res = res.compareTo(entry.getKey()) > 0 ? entry.getKey() : res;
            }
        }

        return Arrays.asList(res.split(" "));

    }


    public static Set<String> getAllSequencesFromList(List<String> websites) {

        Set<String> sequences = new HashSet<>();
        for(int i=0; i< websites.size()-2; i++) {
            for(int j = i+1; j<websites.size() -1; j++) {
                for(int k = j+1; k < websites.size(); k++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(websites.get(i)).append(" ").append(websites.get(j)).append(" ").append(websites.get(k));
                    sequences.add(sb.toString());
                }
            }
        }

        return sequences;
    }
}
