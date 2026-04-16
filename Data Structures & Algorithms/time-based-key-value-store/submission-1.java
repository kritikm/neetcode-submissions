class TimeMap {

    class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Data>> store;

    public TimeMap() {
        store = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        List<Data> data = store.getOrDefault(key, new ArrayList<>());
        data.add(new Data(value, timestamp));
        store.put(key, data);
    }
    
    public String get(String key, int timestamp) {

        if (!store.containsKey(key)) {
            return "";
        }

        List<Data> data = store.get(key);

        int right = data.size() - 1;
        int left = 0;

        int resIdx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            Data midData = data.get(mid);

            if (midData.timestamp == timestamp) {
                return midData.value;
            }
            
            if (midData.timestamp < timestamp) {
                resIdx = Math.max(resIdx, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return resIdx == -1 ? "" : data.get(resIdx).value;
        
    }
}
