package org.xcolab.view.config.spring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("web")
public class WebProperties {

    /**
     * Settings related to browser caching of resources.
     */
    public final Cache cache = new Cache();

    /**
     * Configure whether non-members can see content on the site.
     */
    private final GuestAccess guestAccess = new GuestAccess();

    public Cache getCache() {
        return cache;
    }

    public GuestAccess getGuestAccess() {
        return guestAccess;
    }

    public static class GuestAccess {

        /**
         * Allow guest access to all pages.
         */
        private boolean allowAll = true;

        /**
         * Override to allow access to the home page even if guest access is disabled.
         */
        private boolean alwaysAllowHomepage = true;

        public boolean isAllowAll() {   
            return allowAll;
        }

        public void setAllowAll(boolean allowAll) {
            this.allowAll = allowAll;
        }

        public boolean isAlwaysAllowHomepage() {
            return alwaysAllowHomepage;
        }

        public void setAlwaysAllowHomepage(boolean alwaysAllowHomepage) {
            this.alwaysAllowHomepage = alwaysAllowHomepage;
        }
    }

    public static class Cache {
        /**
         * Browser caching for scripts (JS/CSS)
         */
        private final CacheSettings scripts = new CacheSettings();

        /**
         * Browser caching for theme images.
         */
        private final CacheSettings images = new CacheSettings(true, 365);

        public CacheSettings getScripts() {
            return scripts;
        }

        public CacheSettings getImages() {
            return images;
        }
    }

    public static class CacheSettings {

        /**
         * If false, CacheControl.noCache() is returned (validation via ETag).
         */
        private boolean active = true;

        /**
         * Determines the max age of the resource.
         */
        private long maxAgeDays = 7;

        public CacheSettings() {
        }

        public CacheSettings(boolean active, long maxAgeDays) {

            this.active = active;
            this.maxAgeDays = maxAgeDays;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public long getMaxAgeDays() {
            return maxAgeDays;
        }

        public void setMaxAgeDays(long maxAgeDays) {
            this.maxAgeDays = maxAgeDays;
        }
    }
}