package chapter_8.ex_08_10;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilesWalk{

    public static void main(String args[]) throws IOException {
        Stream<Path> pathStream = Files.walk(new File(".\\tmp").toPath());
        pathStream.forEachOrdered(path -> {
            try {
                String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                List<String> words = Arrays.asList(contents.split("[\\P{L}}]+"));

                if(words.contains("transient") && words.contains("volatile"))
                    System.out.println(path);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        });
        pathStream.close();
    }
}

/* result
./src/com/sun/javadoc/FieldDoc.java
./src/com/sun/jmx/snmp/daemon/CommunicatorServer.java
./src/com/sun/org/apache/bcel/internal/Constants.java
./src/java/awt/AWTEvent.java
./src/java/awt/Component.java
./src/java/awt/Container.java
./src/java/awt/Cursor.java
./src/java/awt/Dialog.java
./src/java/awt/font/NumericShaper.java
./src/java/awt/KeyboardFocusManager.java
./src/java/awt/MenuComponent.java
./src/java/awt/Window.java
./src/java/io/File.java
./src/java/io/ObjectStreamClass.java
./src/java/lang/Class.java
./src/java/lang/invoke/MemberName.java
./src/java/lang/ref/Reference.java
./src/java/lang/reflect/Constructor.java
./src/java/lang/reflect/Executable.java
./src/java/lang/reflect/Field.java
./src/java/lang/reflect/Method.java
./src/java/lang/reflect/Modifier.java
./src/java/lang/reflect/Parameter.java
./src/java/math/BigDecimal.java
./src/java/math/BigInteger.java
./src/java/net/URI.java
./src/java/security/Provider.java
./src/java/text/DateFormatSymbols.java
./src/java/time/chrono/HijrahChronology.java
./src/java/util/AbstractMap.java
./src/java/util/concurrent/atomic/Striped64.java
./src/java/util/concurrent/ConcurrentHashMap.java
./src/java/util/concurrent/ConcurrentLinkedDeque.java
./src/java/util/concurrent/ConcurrentLinkedQueue.java
./src/java/util/concurrent/ConcurrentSkipListMap.java
./src/java/util/concurrent/CopyOnWriteArrayList.java
./src/java/util/concurrent/ForkJoinPool.java
./src/java/util/concurrent/ForkJoinTask.java
./src/java/util/concurrent/FutureTask.java
./src/java/util/concurrent/LinkedTransferQueue.java
./src/java/util/concurrent/locks/AbstractOwnableSynchronizer.java
./src/java/util/concurrent/locks/AbstractQueuedLongSynchronizer.java
./src/java/util/concurrent/locks/AbstractQueuedSynchronizer.java
./src/java/util/concurrent/locks/ReentrantReadWriteLock.java
./src/java/util/concurrent/locks/StampedLock.java
./src/java/util/concurrent/Phaser.java
./src/java/util/concurrent/PriorityBlockingQueue.java
./src/java/util/concurrent/SynchronousQueue.java
./src/java/util/concurrent/ThreadPoolExecutor.java
./src/java/util/Hashtable.java
./src/java/util/Locale.java
./src/java/util/regex/Pattern.java
./src/javax/accessibility/AccessibleContext.java
./src/javax/lang/model/element/Modifier.java
./src/javax/lang/model/SourceVersion.java
./src/javax/management/AttributeList.java
./src/javax/management/remote/rmi/RMIConnector.java
./src/javax/management/timer/Timer.java
./src/javax/security/auth/kerberos/KeyImpl.java
./src/javax/security/auth/Subject.java
./src/javax/swing/JComponent.java
./src/javax/swing/Timer.java
*/