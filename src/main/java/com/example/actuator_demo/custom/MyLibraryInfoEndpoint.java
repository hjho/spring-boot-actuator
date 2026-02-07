package com.example.actuator_demo.custom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.lang.Nullable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Endpoint(id = "myLibraryInfo")
public class MyLibraryInfoEndpoint {

    @WriteOperation
    public void changeSomething(String name, boolean enableSomething) {
        log.info("#### MyLibraryInfoEndpoint: name: {}, enableSomething: {}", name, enableSomething);
    }


    @ReadOperation
    // public String getPathTest(@Selector String path1) {
    public String getPathTest(@Selector(match = Selector.Match.ALL_REMAINING) String[] path1) {
        log.info("#### MyLibraryInfoEndpoint: path1: {}", Arrays.asList(path1));
        return "path1: " + Arrays.asList(path1);
    }

    /**
     * 실제로는 라이브러리를 가져와서, 파싱해서, 실제 정보 줘야되겠지?
     */
    @ReadOperation
    public List<LibraryInfo> getLibraryInfos(@Nullable String name, boolean includeVersion) {

        log.debug("#### MyLibraryInfoEndpoint: {}", name);

        LibraryInfo libraryInfo1 = new LibraryInfo();
        libraryInfo1.setName("lombok");
        libraryInfo1.setVersion("1.0.0");

        LibraryInfo libraryInfo2 = new LibraryInfo();
        libraryInfo2.setName("jackson");
        libraryInfo2.setVersion("2.0.0");

        List<LibraryInfo> libraryInfos = Arrays.asList(libraryInfo1, libraryInfo2);

        if(name != null) {
            libraryInfos = libraryInfos.stream()
                    .filter(lib ->
                            lib.getName().equals(name)
                    )
                    .toList();
        }

        if(includeVersion == false) {
            libraryInfos = libraryInfos.stream()
                    .map(lib -> {
                        LibraryInfo temp = new LibraryInfo();
                        temp.setName(lib.getName());
                        return temp;
                    })
                    .toList();
        }
        return libraryInfos;
    }
}
