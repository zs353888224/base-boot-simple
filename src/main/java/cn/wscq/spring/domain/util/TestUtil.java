package cn.wscq.spring.domain.util;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/18 09:56
 */
public class TestUtil {
    public static class HttpEntityEnclosingDeleteRequest extends HttpEntityEnclosingRequestBase {
        public HttpEntityEnclosingDeleteRequest(final URI uri) {
            super();
            setURI(uri);
        }

        @Override
        public String getMethod() {
            return "DELETE";
        }
    }
    public static class HttpEntityEnclosingPutRequest extends HttpEntityEnclosingRequestBase {
        public HttpEntityEnclosingPutRequest(final URI uri) {
            super();
            setURI(uri);
        }
        @Override
        public String getMethod() {
            return "PUT";
        }
    }
}
