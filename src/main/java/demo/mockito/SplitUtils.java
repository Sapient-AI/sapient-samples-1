package demo.mockito;

import com.google.common.base.Splitter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.val;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@UtilityClass
public final class SplitUtils {

    private static String DEFAULT_SEPARATOR = ",";

    public List<String> toList(@NonNull String list) {
        return toList(list, DEFAULT_SEPARATOR);
    }

    public List<String> toList(@NonNull String list, String separator) {
        return Splitter.on(separator)
                .omitEmptyStrings()
                .trimResults()
                .splitToList(list);
    }

    public String[] toArray(@NonNull String list) {
        return toArray(list, DEFAULT_SEPARATOR);
    }

    public String[] toArray(@NonNull String list, String separator) {
        return toStream(list, separator).toArray(String[]::new);
    }

    public Set<String> toSet(@NonNull String list) {
        return toSet(list, DEFAULT_SEPARATOR);
    }

    public Set<String> toSet(@NonNull String list, String separator) {
        return toStream(list, separator).collect(Collectors.toSet());
    }

    public Map<String, String> toMap(@NonNull String list) {
        return toMap(list, DEFAULT_SEPARATOR, "=");
    }

    public Map<String, String> toMap(@NonNull String list, String entrySeparator, String keyValueSeparator) {
        return Splitter.on(entrySeparator)
                .omitEmptyStrings()
                .trimResults()
                .withKeyValueSeparator(keyValueSeparator)
                .split(list);
    }

    public Stream<String> toStream(@NonNull String list) {
        return toStream(list, DEFAULT_SEPARATOR);
    }

    public Stream<String> toStream(@NonNull String list, String separator) {
        val it = Splitter.on(separator)
                .omitEmptyStrings()
                .trimResults()
                .split(list);
        return StreamSupport.stream(it.spliterator(), false);
    }
}