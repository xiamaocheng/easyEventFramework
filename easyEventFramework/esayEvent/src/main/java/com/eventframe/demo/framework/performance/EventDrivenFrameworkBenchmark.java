package com.eventframe.demo.framework.performance;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.Throughput) // 测试类型：吞吐量
@Warmup(iterations = 5) // 预热次数
@Measurement(iterations = 10) // 测量次数
@State(Scope.Thread) // 每个线程的状态
@Fork(1) // Fork 1个线程进行测试
public class EventDrivenFrameworkBenchmark {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(EventDrivenFrameworkBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void testEventHandling(Blackhole blackhole) {
        // 模拟事件处理逻辑
        // 例如，你可以调用事件处理器或者其他事件驱动的逻辑
        // 在这里，我们简单地将一个计数作为事件
        blackhole.consume(handleEvent(1));
    }

    private boolean handleEvent(int event) {
        // 事件处理逻辑
        // 例如，根据事件类型进行相应的处理
        return true; // 假设事件总是被成功处理
    }
}