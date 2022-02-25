package org.jbehave.core.io.rest.xwiki;

import static java.text.MessageFormat.format;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import org.jbehave.core.io.rest.LoadFromREST;
import org.jbehave.core.io.rest.RESTClient.Type;

/**
 * Loads resource from XWiki pages using the REST API
 */
public class LoadFromXWiki extends LoadFromREST {

    private static final String XWIKI_URI = "{0}?media={1}";

    public LoadFromXWiki(Type type) {
        this(type, null, null);
    }

    public LoadFromXWiki(Type type, String username, String password) {
        super(type, username, password);
    }

    @Override
    protected String uri(String resourcePath, Type type) {
        return format(XWIKI_URI, resourcePath, type.name().toLowerCase());
    }

    @Override
    protected String text(String entity, Type type) {
        switch (type) {
            case JSON:
                Gson gson = new Gson();
                return gson.fromJson(entity, Page.class).content;
            case XML:
                XStream xstream = new XStream();
                XStream.setupDefaultSecurity(xstream);
                xstream.addPermission(AnyTypePermission.ANY);
                xstream.alias("page", Page.class);
                xstream.ignoreUnknownElements();
                return ((Page) xstream.fromXML(entity)).content;
            default:
                return entity;
        }
    }

    private static class Page {
        String content;
    }
}
