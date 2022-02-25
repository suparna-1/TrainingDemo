package org.jbehave.core.io.rest.confluence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.jbehave.core.io.rest.RESTClient;
import org.jbehave.core.io.rest.Resource;
import org.junit.jupiter.api.Test;

class IndexFromConfluenceBehaviour {

    @Test
    void shouldIndexFromConfluence() {
        // given
        IndexFromConfluence indexer = new IndexFromConfluence(new MockRestClient());

        // when
        Map<String, Resource> index = indexer.indexResources("https://demo.confluence.com/display/JBEV/jBehave");

        // then
        assertThat(index.size(), equalTo(2));
    }

    private static class MockRestClient extends RESTClient {

        public MockRestClient() {
            super(Type.XML);
        }

        @Override
        public String get(String uri) {
            if (uri.contains("search")) {
                return read("confluence-search.xml");
            }
            if (uri.contains("12517648")) {
                return read("confluence-story-expanded.xml");
            }
            return read("confluence-story.xml");
        }

        private String read(String path) {
            try {
                return IOUtils.toString(getClass().getClassLoader().getResource(path), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
