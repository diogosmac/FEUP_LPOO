import java.util.List;

public class StringRecipe {
    private List<StringTransformer> transformers;

    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void mix() {
        for (StringTransformer transformer : transformers) {
            transformer.execute();
        }
    }

    public List<StringTransformer> getTransformers() {
        return transformers;
    }
}
