import java.util.List;
import java.util.ListIterator;

public class StringTransformerGroup implements StringTransformer {
    private List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void execute() {
        for (StringTransformer transformer : transformers) {
            transformer.execute();
        }
    }

    public void undo() {
        ListIterator<StringTransformer> li = transformers.listIterator(transformers.size());

        while (li.hasPrevious()) {
            li.previous().undo();
        }
    }
}
