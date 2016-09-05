package org.xcolab.util.http.client.queries;

import org.springframework.core.ParameterizedTypeReference;

import org.xcolab.util.http.RequestUtils;
import org.xcolab.util.http.UriBuilder;
import org.xcolab.util.http.caching.CacheKey;
import org.xcolab.util.http.caching.CachingStrategy;
import org.xcolab.util.http.client.RestResource;

import java.util.List;

public class ListQuery<T> implements CacheableQuery<T, List<T>> {
    private final UriBuilder uriBuilder;
    private final ParameterizedTypeReference<List<T>> typeReference;
    private CacheKey<T, List<T>> cacheKey;
    private CachingStrategy cachingStrategy;

    public ListQuery(RestResource<T> restResource,
            ParameterizedTypeReference<List<T>> typeReference) {
        this.typeReference = typeReference;
        this.uriBuilder = restResource.getResourceUrl();
    }

    @Override
    public List<T> execute() {
        if (cacheKey == null) {
            return RequestUtils.getList(uriBuilder, typeReference);
        } else {
            return RequestUtils.getList(uriBuilder, typeReference, cacheKey, cachingStrategy);
        }
    }

    public ListResult<T> executeWithResult() {
        return new ListResult<>(this);
    }

    public ListQuery<T> addRange(int startRecord, int limitRecord) {
        uriBuilder.queryParam("startRecord", startRecord)
                .queryParam("limitRecord", limitRecord);
        return this;
    }

    @Override
    public ListQuery<T> withCache(CacheKey<T, List<T>> cacheKey, CachingStrategy cachingStrategy) {
        this.cacheKey = cacheKey;
        this.cachingStrategy = cachingStrategy;
        return this;
    }

    @Override
    public ListQuery<T> queryParam(String name, Object value) {
        uriBuilder.queryParam(name, value);
        return this;
    }

    @Override
    public ListQuery<T> optionalQueryParam(String name, Object value) {
        uriBuilder.optionalQueryParam(name, value);
        return this;
    }

    public static class ListResult<T> {
        private final ListQuery<T> query;

        private ListResult(ListQuery<T> query) {
            this.query = query;
        }

        public List<T> get() {
            return query.execute();
        }

        public T getOne() {
            //fetch two elements so we can check if the result is unique
            List<T> result = query.addRange(0, 2).execute();
            if (result.size() == 1) {
                return result.get(0);
            }
            throw new IndexOutOfBoundsException("Expected exactly one element, found " + result.size());
        }

        public T getOneIfExists() {
            //fetch two elements so we can check if the result is unique
            List<T> result = query.addRange(0, 2).execute();
            if (result.size() == 1) {
                return result.get(0);
            }
            if (result.isEmpty()) {
                return null;
            }
            throw new IndexOutOfBoundsException("Expected at most one element, found 2 or more");
        }

        public T getFirst() {
            List<T> result = query.addRange(0, 1).execute();
            if (!result.isEmpty()) {
                return result.get(0);
            }
            throw new IndexOutOfBoundsException("Can't get first element of empty list");
        }

        public T getFirstIfExists() {
            List<T> result = query.addRange(0, 1).execute();
            if (!result.isEmpty()) {
                return result.get(0);
            }
            return null;
        }
    }
}
