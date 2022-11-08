package org.eclipse.cargotracker.domain.model.cargo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.eclipse.cargotracker.domain.model.handling.HandlingEvent;
import org.eclipse.cargotracker.domain.model.handling.HandlingHistory;
import org.eclipse.cargotracker.domain.model.location.Location;
import org.eclipse.cargotracker.domain.model.location.UnLocode;
import org.eclipse.cargotracker.domain.model.voyage.Voyage;
import org.junit.Ignore;
import org.junit.Test;

public class DeliveryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Delivery#Delivery()}
     *   <li>{@link Delivery#setCalculatedAt(LocalDateTime)}
     *   <li>{@link Delivery#setLastEvent(HandlingEvent)}
     *   <li>{@link Delivery#setLastKnownLocation(Location)}
     *   <li>{@link Delivery#setMisdirected(boolean)}
     *   <li>{@link Delivery#setRoutingStatus(RoutingStatus)}
     *   <li>{@link Delivery#setTransportStatus(TransportStatus)}
     *   <li>{@link Delivery#setUnloadedAtDestination(boolean)}
     *   <li>{@link Delivery#getCalculatedAt()}
     *   <li>{@link Delivery#getEstimatedTimeOfArrival()}
     *   <li>{@link Delivery#getNextExpectedActivity()}
     *   <li>{@link Delivery#getRoutingStatus()}
     *   <li>{@link Delivery#getTransportStatus()}
     *   <li>{@link Delivery#isMisdirected()}
     *   <li>{@link Delivery#isUnloadedAtDestination()}
     * </ul>
     */
    @Test
    public void testConstructor() {
        Delivery actualDelivery = new Delivery();
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualDelivery.setCalculatedAt(ofResult);
        actualDelivery.setLastEvent(new HandlingEvent());
        actualDelivery.setLastKnownLocation(new Location());
        actualDelivery.setMisdirected(true);
        actualDelivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        actualDelivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        actualDelivery.setUnloadedAtDestination(true);
        assertSame(ofResult, actualDelivery.getCalculatedAt());
        assertNull(actualDelivery.getEstimatedTimeOfArrival());
        assertNull(actualDelivery.getNextExpectedActivity());
        assertEquals(RoutingStatus.NOT_ROUTED, actualDelivery.getRoutingStatus());
        assertEquals(TransportStatus.NOT_RECEIVED, actualDelivery.getTransportStatus());
        assertTrue(actualDelivery.isMisdirected());
        assertTrue(actualDelivery.isUnloadedAtDestination());
    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //   See https://diff.blue/R013 to resolve this issue.

        HandlingEvent lastEvent = new HandlingEvent();
        Itinerary itinerary = new Itinerary();
        new Delivery(lastEvent, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        HandlingEvent lastEvent = new HandlingEvent();
        new Delivery(lastEvent, null, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //   See https://diff.blue/R013 to resolve this issue.

        Itinerary itinerary = new Itinerary();
        new Delivery(null, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    public void testConstructor5() {
        Delivery actualDelivery = new Delivery(null, null, new RouteSpecification());

        assertFalse(actualDelivery.isUnloadedAtDestination());
        assertFalse(actualDelivery.isMisdirected());
        assertEquals(TransportStatus.NOT_RECEIVED, actualDelivery.getTransportStatus());
        assertEquals(RoutingStatus.NOT_ROUTED, actualDelivery.getRoutingStatus());
        HandlingActivity expectedNextExpectedActivity = actualDelivery.NO_ACTIVITY;
        assertSame(expectedNextExpectedActivity, actualDelivery.getNextExpectedActivity());
        assertNull(actualDelivery.getEstimatedTimeOfArrival());
    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:55)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        HandlingEvent lastEvent = new HandlingEvent();

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        Itinerary itinerary = new Itinerary(legList);
        new Delivery(lastEvent, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:55)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        HandlingEvent lastEvent = new HandlingEvent();

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        legList.add(new Leg());
        Itinerary itinerary = new Itinerary(legList);
        new Delivery(lastEvent, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        Itinerary itinerary = new Itinerary(legList);
        new Delivery(null, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.lambda$isExpected$0(Itinerary.java:68)
        //       at java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
        //       at java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1361)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:516)
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:66)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        Cargo cargo = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        HandlingEvent lastEvent = new HandlingEvent(cargo, completionTime, registrationTime, HandlingEvent.Type.LOAD,
                location, new Voyage());

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        Itinerary itinerary = new Itinerary(legList);
        new Delivery(lastEvent, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.location.Location.sameIdentityAs(Location.java:86)
        //       at org.eclipse.cargotracker.domain.model.location.Location.equals(Location.java:82)
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.lambda$isExpected$0(Itinerary.java:68)
        //       at java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
        //       at java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1361)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:516)
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:66)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        Cargo cargo = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        HandlingEvent lastEvent = new HandlingEvent(cargo, completionTime, registrationTime, HandlingEvent.Type.LOAD,
                location, new Voyage());

        ArrayList<Leg> legList = new ArrayList<>();
        Voyage voyage = new Voyage();
        Location loadLocation = new Location();
        Location unloadLocation = new Location();
        LocalDateTime loadTime = LocalDateTime.of(1, 1, 1, 1, 1);
        legList.add(new Leg(voyage, loadLocation, unloadLocation, loadTime, LocalDateTime.of(1, 1, 1, 1, 1)));
        Itinerary itinerary = new Itinerary(legList);
        new Delivery(lastEvent, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //   See https://diff.blue/R013 to resolve this issue.

        Cargo cargo = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        HandlingEvent lastEvent = new HandlingEvent(cargo, completionTime, registrationTime, HandlingEvent.Type.LOAD,
                location, new Voyage());

        ArrayList<Leg> legList = new ArrayList<>();
        Voyage voyage = new Voyage();
        Location loadLocation = new Location(new UnLocode(), "Name");

        Location unloadLocation = new Location();
        LocalDateTime loadTime = LocalDateTime.of(1, 1, 1, 1, 1);
        legList.add(new Leg(voyage, loadLocation, unloadLocation, loadTime, LocalDateTime.of(1, 1, 1, 1, 1)));
        Itinerary itinerary = new Itinerary(legList);
        new Delivery(lastEvent, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor12() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.location.UnLocode.sameValueAs(UnLocode.java:70)
        //       at org.eclipse.cargotracker.domain.model.location.Location.sameIdentityAs(Location.java:86)
        //       at org.eclipse.cargotracker.domain.model.location.Location.equals(Location.java:82)
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.lambda$isExpected$0(Itinerary.java:68)
        //       at java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
        //       at java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1361)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:516)
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:66)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        Cargo cargo = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location(new UnLocode(), "Name");

        HandlingEvent lastEvent = new HandlingEvent(cargo, completionTime, registrationTime, HandlingEvent.Type.LOAD,
                location, new Voyage());

        ArrayList<Leg> legList = new ArrayList<>();
        Voyage voyage = new Voyage();
        Location loadLocation = new Location(new UnLocode(), "Name");

        Location unloadLocation = new Location();
        LocalDateTime loadTime = LocalDateTime.of(1, 1, 1, 1, 1);
        legList.add(new Leg(voyage, loadLocation, unloadLocation, loadTime, LocalDateTime.of(1, 1, 1, 1, 1)));
        Itinerary itinerary = new Itinerary(legList);
        new Delivery(lastEvent, itinerary, new RouteSpecification());

    }

    /**
     * Method under test: {@link Delivery#Delivery(HandlingEvent, Itinerary, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor13() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.location.UnLocode.sameValueAs(UnLocode.java:70)
        //       at org.eclipse.cargotracker.domain.model.location.Location.sameIdentityAs(Location.java:86)
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //   See https://diff.blue/R013 to resolve this issue.

        HandlingEvent lastEvent = new HandlingEvent();
        Itinerary itinerary = new Itinerary();
        Location origin = new Location(new UnLocode(), "Name");

        new Delivery(lastEvent, itinerary, new RouteSpecification(origin, new Location(), LocalDate.ofEpochDay(1L)));

    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        RouteSpecification routeSpecification = new RouteSpecification();
        Itinerary itinerary = new Itinerary();
        Delivery.derivedFrom(routeSpecification, itinerary, new HandlingHistory(new ArrayList<>()));
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Route specification is required
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:114)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery.derivedFrom(null, null, null);
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    public void testDerivedFrom3() {
        RouteSpecification routeSpecification = new RouteSpecification();
        Delivery actualDerivedFromResult = Delivery.derivedFrom(routeSpecification, null,
                new HandlingHistory(new ArrayList<>()));
        assertFalse(actualDerivedFromResult.isUnloadedAtDestination());
        assertFalse(actualDerivedFromResult.isMisdirected());
        assertEquals(TransportStatus.NOT_RECEIVED, actualDerivedFromResult.getTransportStatus());
        assertEquals(RoutingStatus.NOT_ROUTED, actualDerivedFromResult.getRoutingStatus());
        HandlingActivity expectedNextExpectedActivity = actualDerivedFromResult.NO_ACTIVITY;
        assertSame(expectedNextExpectedActivity, actualDerivedFromResult.getNextExpectedActivity());
        assertNull(actualDerivedFromResult.getEstimatedTimeOfArrival());
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        RouteSpecification routeSpecification = new RouteSpecification();
        Itinerary itinerary = new Itinerary();

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        Delivery.derivedFrom(routeSpecification, itinerary, new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        RouteSpecification routeSpecification = new RouteSpecification();
        Itinerary itinerary = new Itinerary();

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        handlingEventList.add(new HandlingEvent());
        Delivery.derivedFrom(routeSpecification, itinerary, new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        RouteSpecification routeSpecification = new RouteSpecification();
        Itinerary itinerary = new Itinerary();

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        handlingEventList.add(new HandlingEvent());
        handlingEventList.add(new HandlingEvent());
        Delivery.derivedFrom(routeSpecification, itinerary, new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Delivery history is required
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:115)
        //   See https://diff.blue/R013 to resolve this issue.

        RouteSpecification routeSpecification = new RouteSpecification();
        Delivery.derivedFrom(routeSpecification, new Itinerary(), null);
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        RouteSpecification routeSpecification = new RouteSpecification();

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        Delivery.derivedFrom(routeSpecification, null, new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.location.UnLocode.sameValueAs(UnLocode.java:70)
        //       at org.eclipse.cargotracker.domain.model.location.Location.sameIdentityAs(Location.java:86)
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        Location origin = new Location(new UnLocode(), "Name");

        RouteSpecification routeSpecification = new RouteSpecification(origin, new Location(), LocalDate.ofEpochDay(1L));

        Itinerary itinerary = new Itinerary();
        Delivery.derivedFrom(routeSpecification, itinerary, new HandlingHistory(new ArrayList<>()));
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        RouteSpecification routeSpecification = new RouteSpecification();

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        Itinerary itinerary = new Itinerary(legList);
        Delivery.derivedFrom(routeSpecification, itinerary, new HandlingHistory(new ArrayList<>()));
    }

    /**
     * Method under test: {@link Delivery#derivedFrom(RouteSpecification, Itinerary, HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDerivedFrom11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:55)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        RouteSpecification routeSpecification = new RouteSpecification();

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        Itinerary itinerary = new Itinerary(legList);

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        Delivery.derivedFrom(routeSpecification, itinerary, new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        RouteSpecification routeSpecification = new RouteSpecification();
        delivery.updateOnRouting(routeSpecification, new Itinerary());
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Route specification is required
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:128)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        delivery.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery.setLastEvent(new HandlingEvent());
        delivery.setLastKnownLocation(new Location());
        delivery.setMisdirected(true);
        delivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery.setUnloadedAtDestination(true);
        delivery.updateOnRouting(null, null);
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    public void testUpdateOnRouting3() {
        Delivery delivery = new Delivery();
        Delivery actualUpdateOnRoutingResult = delivery.updateOnRouting(new RouteSpecification(), null);
        assertFalse(actualUpdateOnRoutingResult.isUnloadedAtDestination());
        assertFalse(actualUpdateOnRoutingResult.isMisdirected());
        assertEquals(TransportStatus.NOT_RECEIVED, actualUpdateOnRoutingResult.getTransportStatus());
        assertEquals(RoutingStatus.NOT_ROUTED, actualUpdateOnRoutingResult.getRoutingStatus());
        HandlingActivity expectedNextExpectedActivity = actualUpdateOnRoutingResult.NO_ACTIVITY;
        assertSame(expectedNextExpectedActivity, actualUpdateOnRoutingResult.getNextExpectedActivity());
        assertNull(actualUpdateOnRoutingResult.getEstimatedTimeOfArrival());
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        delivery.setLastEvent(new HandlingEvent());
        RouteSpecification routeSpecification = new RouteSpecification();
        delivery.updateOnRouting(routeSpecification, new Itinerary());
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        delivery.setLastEvent(new HandlingEvent());
        delivery.updateOnRouting(new RouteSpecification(), null);
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.location.UnLocode.sameValueAs(UnLocode.java:70)
        //       at org.eclipse.cargotracker.domain.model.location.Location.sameIdentityAs(Location.java:86)
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        Location origin = new Location(new UnLocode(), "Name");

        RouteSpecification routeSpecification = new RouteSpecification(origin, new Location(), LocalDate.ofEpochDay(1L));

        delivery.updateOnRouting(routeSpecification, new Itinerary());
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        RouteSpecification routeSpecification = new RouteSpecification();

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        delivery.updateOnRouting(routeSpecification, new Itinerary(legList));
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:55)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        delivery.setLastEvent(new HandlingEvent());
        RouteSpecification routeSpecification = new RouteSpecification();

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        delivery.updateOnRouting(routeSpecification, new Itinerary(legList));
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.lambda$isExpected$0(Itinerary.java:68)
        //       at java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
        //       at java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1361)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:516)
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:66)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        Cargo cargo = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        delivery.setLastEvent(
                new HandlingEvent(cargo, completionTime, registrationTime, HandlingEvent.Type.LOAD, location, new Voyage()));
        RouteSpecification routeSpecification = new RouteSpecification();

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        delivery.updateOnRouting(routeSpecification, new Itinerary(legList));
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.location.Location.sameIdentityAs(Location.java:86)
        //       at org.eclipse.cargotracker.domain.model.location.Location.equals(Location.java:82)
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.lambda$isExpected$0(Itinerary.java:68)
        //       at java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
        //       at java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1361)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:516)
        //       at org.eclipse.cargotracker.domain.model.cargo.Itinerary.isExpected(Itinerary.java:66)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateMisdirectionStatus(Delivery.java:250)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:93)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        Cargo cargo = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        delivery.setLastEvent(
                new HandlingEvent(cargo, completionTime, registrationTime, HandlingEvent.Type.LOAD, location, new Voyage()));
        RouteSpecification routeSpecification = new RouteSpecification();

        ArrayList<Leg> legList = new ArrayList<>();
        Voyage voyage = new Voyage();
        Location loadLocation = new Location();
        Location unloadLocation = new Location();
        LocalDateTime loadTime = LocalDateTime.of(1, 1, 1, 1, 1);
        legList.add(new Leg(voyage, loadLocation, unloadLocation, loadTime, LocalDateTime.of(1, 1, 1, 1, 1)));
        delivery.updateOnRouting(routeSpecification, new Itinerary(legList));
    }

    /**
     * Method under test: {@link Delivery#updateOnRouting(RouteSpecification, Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateOnRouting11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        Cargo cargo = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        delivery.setLastEvent(
                new HandlingEvent(cargo, completionTime, registrationTime, HandlingEvent.Type.LOAD, location, new Voyage()));
        RouteSpecification routeSpecification = new RouteSpecification();

        ArrayList<Leg> legList = new ArrayList<>();
        Voyage voyage = new Voyage();
        Location loadLocation = new Location(new UnLocode(), "Route specification is required");

        Location unloadLocation = new Location();
        LocalDateTime loadTime = LocalDateTime.of(1, 1, 1, 1, 1);
        legList.add(new Leg(voyage, loadLocation, unloadLocation, loadTime, LocalDateTime.of(1, 1, 1, 1, 1)));
        delivery.updateOnRouting(routeSpecification, new Itinerary(legList));
    }

    /**
     * Method under test: {@link Delivery#getLastKnownLocation()}
     */
    @Test
    public void testGetLastKnownLocation() {
        Location actualLastKnownLocation = (new Delivery()).getLastKnownLocation();
        assertSame(actualLastKnownLocation.UNKNOWN, actualLastKnownLocation);
    }

    /**
     * Method under test: {@link Delivery#getLastKnownLocation()}
     */
    @Test
    public void testGetLastKnownLocation2() {
        Delivery delivery = new Delivery();
        delivery.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery.setLastEvent(new HandlingEvent());
        Location location = new Location();
        delivery.setLastKnownLocation(location);
        delivery.setMisdirected(true);
        delivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery.setUnloadedAtDestination(true);
        assertSame(location, delivery.getLastKnownLocation());
    }

    /**
     * Method under test: {@link Delivery#getCurrentVoyage()}
     */
    @Test
    public void testGetCurrentVoyage() {
        Voyage actualCurrentVoyage = (new Delivery()).getCurrentVoyage();
        assertSame(actualCurrentVoyage.NONE, actualCurrentVoyage);
    }

    /**
     * Method under test: {@link Delivery#equals(Object)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEquals4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.location.Location.sameIdentityAs(Location.java:86)
        //       at org.eclipse.cargotracker.domain.model.location.Location.equals(Location.java:82)
        //       at org.apache.commons.lang3.builder.EqualsBuilder.append(EqualsBuilder.java:649)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.sameValueAs(Delivery.java:341)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.equals(Delivery.java:364)
        //   See https://diff.blue/R013 to resolve this issue.

        Delivery delivery = new Delivery();
        delivery.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery.setLastEvent(new HandlingEvent());
        delivery.setLastKnownLocation(new Location());
        delivery.setMisdirected(true);
        delivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery.setUnloadedAtDestination(true);

        Delivery delivery1 = new Delivery();
        delivery1.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery1.setLastEvent(new HandlingEvent());
        delivery1.setLastKnownLocation(new Location());
        delivery1.setMisdirected(true);
        delivery1.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery1.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery1.setUnloadedAtDestination(true);
        assertThrows(NullPointerException.class, () -> delivery.equals(delivery1));
    }

    /**
     * Method under test: {@link Delivery#equals(Object)}
     */
    @Test
    public void testEquals() {
        Delivery delivery = new Delivery();
        delivery.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery.setLastEvent(new HandlingEvent());
        delivery.setLastKnownLocation(new Location());
        delivery.setMisdirected(true);
        delivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery.setUnloadedAtDestination(true);
        assertNotEquals(delivery, null);
    }

    /**
     * Method under test: {@link Delivery#equals(Object)}
     */
    @Test
    public void testEquals2() {
        Delivery delivery = new Delivery();
        delivery.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery.setLastEvent(new HandlingEvent());
        delivery.setLastKnownLocation(new Location());
        delivery.setMisdirected(true);
        delivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery.setUnloadedAtDestination(true);
        assertNotEquals(delivery, "Different type to Delivery");
    }

    /**
     * Method under test: {@link Delivery#equals(Object)}
     */
    @Test
    public void testEquals3() {
        Delivery delivery = new Delivery();
        delivery.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery.setLastEvent(new HandlingEvent());
        delivery.setLastKnownLocation(new Location());
        delivery.setMisdirected(true);
        delivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery.setUnloadedAtDestination(true);
        assertEquals(delivery, delivery);
    }

    /**
     * Method under test: {@link Delivery#equals(Object)}
     */
    @Test
    public void testEquals5() {
        Delivery delivery = new Delivery();
        delivery.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery.setLastEvent(new HandlingEvent());
        delivery.setLastKnownLocation(null);
        delivery.setMisdirected(true);
        delivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery.setUnloadedAtDestination(true);

        Delivery delivery1 = new Delivery();
        delivery1.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery1.setLastEvent(new HandlingEvent());
        delivery1.setLastKnownLocation(new Location());
        delivery1.setMisdirected(true);
        delivery1.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery1.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery1.setUnloadedAtDestination(true);
        assertNotEquals(delivery, delivery1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Delivery#equals(Object)}
     *   <li>{@link Delivery#hashCode()}
     * </ul>
     */
    @Test
    public void testEquals6() {
        Delivery delivery = new Delivery();
        delivery.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery.setLastEvent(new HandlingEvent());
        delivery.setLastKnownLocation(null);
        delivery.setMisdirected(true);
        delivery.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery.setUnloadedAtDestination(true);

        Delivery delivery1 = new Delivery();
        delivery1.setCalculatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        delivery1.setLastEvent(new HandlingEvent());
        delivery1.setLastKnownLocation(null);
        delivery1.setMisdirected(true);
        delivery1.setRoutingStatus(RoutingStatus.NOT_ROUTED);
        delivery1.setTransportStatus(TransportStatus.NOT_RECEIVED);
        delivery1.setUnloadedAtDestination(true);
        assertEquals(delivery, delivery1);
        int expectedHashCodeResult = delivery.hashCode();
        assertEquals(expectedHashCodeResult, delivery1.hashCode());
    }
}

