package com.company.design;

import java.util.*;

public class FileSystem {

    Dir dir;
    class Dir {
        Map<String, Dir> dirs = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }
    public FileSystem() {
        this.dir = new Dir();
    }

    public List<String> ls(String path) {

        Dir t = dir;
        if(path.length() == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        if(path.equals("/") || !path.startsWith("/")){
            if(t.files.containsKey(path)){
                result.add(path);
                return result;
            }
            Set<String> dirs = t.dirs.keySet();
            Set<String> files = t.files.keySet();
            result.addAll(dirs); result.addAll(files);
            Collections.sort(result, (s1, s2) -> s1.compareTo(s2));
            return result;
        }

        String[] paths = path.split("/");

        for(int i=1; i<paths.length-1; i++) {
            t = t.dirs.get(paths[i]);
        }
        if(t.files.containsKey(paths[paths.length-1])) {
            result.add(paths[paths.length-1]);
            return result;
        } else {
            t = t.dirs.get(paths[paths.length-1]);
        }
        Set<String> dirs = t.dirs.keySet();
        Set<String> files = t.files.keySet();
        result.addAll(dirs); result.addAll(files);
        Collections.sort(result, (s1, s2) -> s1.compareTo(s2));

        return result;

    }

    public void mkdir(String path) {
        Dir t=dir;


        String[] paths = path.split("/");
        for(int i = 1; i<paths.length; i++) {

            if(!t.dirs.containsKey(paths[i]))
                t.dirs.put(paths[i], new Dir());
            t=t.dirs.get(paths[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Dir t = dir;
        String[] paths = filePath.split("/");
        for(int i = 1; i< paths.length -1; i++){
            t = t.dirs.get(paths[i]);
        }

        t.files.put(paths[paths.length-1], t.files.getOrDefault(paths[paths.length-1], "") +content);


    }

    public String readContentFromFile(String filePath) {

        Dir t = dir;
        String[] paths = filePath.split("/");

        for(int i=1; i< paths.length-1; i++) {
            t = t.dirs.get(paths[i]);
        }
        return t.files.get(paths[paths.length-1]);

    }
}
