# jxfs-lookup-java 
J/XFS Constant Field Values Lookup for Java 

## Installation

Download the [jar](https://github.com/amimaro/jxfs-lookup-java/releases/download/v1.0/jxfslookup-1.0.0.jar).

## Usage

```java
import com.jxfslookup.JxfsLookup;

public class Test {

  Test() {
    JxfsLookup jxfsLookup = new JxfsLookup();
    jxfsLookup.printHashMap(jxfsLookup.querycode("1024"));
  }
  
  public static void main(String[] args) {
    new Test();
  }
  
}
```

## Testing

```bash
mvn test
```

## License

MIT

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request

Crafted with <3 by amimaro ([@amir_zln](https://twitter.com/amir_zln)).
