package org.eclipse.cargotracker.domain.model.cargo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

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

public class CargoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Cargo#Cargo()}
     *   <li>{@link Cargo#setOrigin(Location)}
     *   <li>{@link Cargo#getDelivery()}
     *   <li>{@link Cargo#getOrigin()}
     *   <li>{@link Cargo#getRouteSpecification()}
     *   <li>{@link Cargo#getTrackingId()}
     * </ul>
     */
    @Test
    public void testConstructor() {
        Cargo actualCargo = new Cargo();
        Location location = new Location();
        actualCargo.setOrigin(location);
        assertNull(actualCargo.getDelivery());
        assertSame(location, actualCargo.getOrigin());
        assertNull(actualCargo.getRouteSpecification());
        assertNull(actualCargo.getTrackingId());
    }

    /**
     * Method under test: {@link Cargo#Cargo(TrackingId, RouteSpecification)}
     */
    @Test
    public void testConstructor2() {
        TrackingId trackingId = new TrackingId();
        RouteSpecification routeSpecification = new RouteSpecification();
        Cargo actualCargo = new Cargo(trackingId, routeSpecification);

        assertSame(trackingId, actualCargo.getTrackingId());
        assertSame(routeSpecification, actualCargo.getRouteSpecification());
        assertNull(actualCargo.getOrigin());
        Delivery delivery = actualCargo.getDelivery();
        assertFalse(delivery.isUnloadedAtDestination());
        assertFalse(delivery.isMisdirected());
        assertEquals(TransportStatus.NOT_RECEIVED, delivery.getTransportStatus());
        assertEquals(RoutingStatus.NOT_ROUTED, delivery.getRoutingStatus());
        Location expectedLastKnownLocation = actualCargo.getItinerary().getInitialDepartureLocation();
        assertSame(expectedLastKnownLocation, delivery.getLastKnownLocation());
        assertNull(delivery.getEstimatedTimeOfArrival());
    }

    /**
     * Method under test: {@link Cargo#Cargo(TrackingId, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Tracking ID is required.
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.<init>(Cargo.java:85)
        //   See https://diff.blue/R013 to resolve this issue.

        new Cargo(null, null);

    }

    /**
     * Method under test: {@link Cargo#Cargo(TrackingId, RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Route specification is required.
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.<init>(Cargo.java:86)
        //   See https://diff.blue/R013 to resolve this issue.

        new Cargo(new TrackingId(), null);

    }

    /**
     * Method under test: {@link Cargo#getItinerary()}
     */
    @Test
    public void testGetItinerary() {
        Itinerary actualItinerary = (new Cargo()).getItinerary();
        assertSame(actualItinerary.EMPTY_ITINERARY, actualItinerary);
    }

    /**
     * Method under test: {@link Cargo#getItinerary()}
     */
    @Test
    public void testGetItinerary2() {
        TrackingId trackingId = new TrackingId();
        Itinerary actualItinerary = (new Cargo(trackingId, new RouteSpecification())).getItinerary();
        assertSame(actualItinerary.EMPTY_ITINERARY, actualItinerary);
    }

    /**
     * Method under test: {@link Cargo#specifyNewRoute(RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSpecifyNewRoute() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.specifyNewRoute(Cargo.java:132)
        //   See https://diff.blue/R013 to resolve this issue.

        Cargo cargo = new Cargo();
        cargo.specifyNewRoute(new RouteSpecification());
    }

    /**
     * Method under test: {@link Cargo#specifyNewRoute(RouteSpecification)}
     */
    @Test
    public void testSpecifyNewRoute2() {
        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());
        RouteSpecification routeSpecification = new RouteSpecification();
        cargo.specifyNewRoute(routeSpecification);
        assertSame(routeSpecification, cargo.getRouteSpecification());
        Delivery delivery = cargo.getDelivery();
        assertFalse(delivery.isUnloadedAtDestination());
        assertFalse(delivery.isMisdirected());
        assertEquals(TransportStatus.NOT_RECEIVED, delivery.getTransportStatus());
        assertEquals(RoutingStatus.NOT_ROUTED, delivery.getRoutingStatus());
        Location expectedLastKnownLocation = cargo.getItinerary().getInitialDepartureLocation();
        assertSame(expectedLastKnownLocation, delivery.getLastKnownLocation());
        assertNull(delivery.getEstimatedTimeOfArrival());
    }

    /**
     * Method under test: {@link Cargo#specifyNewRoute(RouteSpecification)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSpecifyNewRoute3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Route specification is required.
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.specifyNewRoute(Cargo.java:128)
        //   See https://diff.blue/R013 to resolve this issue.

        (new Cargo()).specifyNewRoute(null);
    }

    /**
     * Method under test: {@link Cargo#assignToRoute(Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAssignToRoute() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.assignToRoute(Cargo.java:140)
        //   See https://diff.blue/R013 to resolve this issue.

        Cargo cargo = new Cargo();
        cargo.assignToRoute(new Itinerary());
    }

    /**
     * Method under test: {@link Cargo#assignToRoute(Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAssignToRoute2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.assignToRoute(Cargo.java:140)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());
        cargo.assignToRoute(new Itinerary());
    }

    /**
     * Method under test: {@link Cargo#assignToRoute(Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAssignToRoute3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Itinerary is required for assignment.
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.assignToRoute(Cargo.java:136)
        //   See https://diff.blue/R013 to resolve this issue.

        (new Cargo()).assignToRoute(null);
    }

    /**
     * Method under test: {@link Cargo#assignToRoute(Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAssignToRoute4() {
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
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.assignToRoute(Cargo.java:140)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Location origin = new Location(new UnLocode(), "Name");

        Cargo cargo = new Cargo(trackingId, new RouteSpecification(origin, new Location(), LocalDate.ofEpochDay(1L)));
        cargo.assignToRoute(new Itinerary());
    }

    /**
     * Method under test: {@link Cargo#assignToRoute(Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAssignToRoute5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.assignToRoute(Cargo.java:140)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        cargo.assignToRoute(new Itinerary(legList));
    }

    /**
     * Method under test: {@link Cargo#assignToRoute(Itinerary)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAssignToRoute6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.location.Location.sameIdentityAs(Location.java:86)
        //       at org.eclipse.cargotracker.domain.model.cargo.RouteSpecification.isSatisfiedBy(RouteSpecification.java:70)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateRoutingStatus(Delivery.java:319)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:94)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.updateOnRouting(Delivery.java:130)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.assignToRoute(Cargo.java:140)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Location origin = new Location(new UnLocode(), "Name");

        Cargo cargo = new Cargo(trackingId, new RouteSpecification(origin, new Location(), LocalDate.ofEpochDay(1L)));

        ArrayList<Leg> legList = new ArrayList<>();
        legList.add(new Leg());
        cargo.assignToRoute(new Itinerary(legList));
    }

    /**
     * Method under test: {@link Cargo#assignToRoute(Itinerary)}
     */
    @Test
    public void testAssignToRoute7() {
        TrackingId trackingId = new TrackingId();
        Location origin = new Location(new UnLocode(), "Name");

        Cargo cargo = new Cargo(trackingId, new RouteSpecification(origin, new Location(), LocalDate.ofEpochDay(1L)));

        ArrayList<Leg> legList = new ArrayList<>();
        Voyage voyage = new Voyage();
        Location loadLocation = new Location();
        Location location = new Location();
        LocalDateTime loadTime = LocalDateTime.of(1, 1, 1, 1, 1);
        legList.add(new Leg(voyage, loadLocation, location, loadTime, LocalDateTime.of(1, 1, 1, 1, 1)));
        Itinerary itinerary = new Itinerary(legList);
        cargo.assignToRoute(itinerary);
        assertSame(itinerary, cargo.getItinerary());
        Delivery delivery = cargo.getDelivery();
        assertFalse(delivery.isUnloadedAtDestination());
        Location expectedLastKnownLocation = location.UNKNOWN;
        assertSame(expectedLastKnownLocation, delivery.getLastKnownLocation());
        assertFalse(delivery.isMisdirected());
        assertEquals(RoutingStatus.MISROUTED, delivery.getRoutingStatus());
        assertEquals(TransportStatus.NOT_RECEIVED, delivery.getTransportStatus());
        Voyage expectedCurrentVoyage = voyage.NONE;
        assertSame(expectedCurrentVoyage, delivery.getCurrentVoyage());
        assertNull(delivery.getEstimatedTimeOfArrival());
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Route specification is required
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:114)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        Cargo cargo = new Cargo();
        cargo.deriveDeliveryProgress(new HandlingHistory(new ArrayList<>()));
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    public void testDeriveDeliveryProgress2() {
        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());
        cargo.deriveDeliveryProgress(new HandlingHistory(new ArrayList<>()));
        Delivery delivery = cargo.getDelivery();
        assertFalse(delivery.isUnloadedAtDestination());
        assertFalse(delivery.isMisdirected());
        assertEquals(TransportStatus.NOT_RECEIVED, delivery.getTransportStatus());
        assertEquals(RoutingStatus.NOT_ROUTED, delivery.getRoutingStatus());
        Location expectedLastKnownLocation = cargo.getItinerary().getInitialDepartureLocation();
        assertSame(expectedLastKnownLocation, delivery.getLastKnownLocation());
        assertNull(delivery.getEstimatedTimeOfArrival());
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateTransportStatus(Delivery.java:216)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:95)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        cargo.deriveDeliveryProgress(new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateTransportStatus(Delivery.java:216)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:95)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        handlingEventList.add(new HandlingEvent());
        cargo.deriveDeliveryProgress(new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.calculateTransportStatus(Delivery.java:216)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.<init>(Delivery.java:95)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:119)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        handlingEventList.add(new HandlingEvent());
        handlingEventList.add(new HandlingEvent());
        cargo.deriveDeliveryProgress(new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Delivery history is required
        //       at org.apache.commons.lang3.Validate.notNull(Validate.java:225)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:115)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        (new Cargo(trackingId, new RouteSpecification())).deriveDeliveryProgress(null);
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.hashCode(Cargo.java:186)
        //       at org.apache.commons.lang3.builder.HashCodeBuilder.append(HashCodeBuilder.java:848)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingEvent.hashCode(HandlingEvent.java:228)
        //       at java.util.HashMap.hash(HashMap.java:340)
        //       at java.util.HashMap.put(HashMap.java:613)
        //       at java.util.HashSet.add(HashSet.java:220)
        //       at java.util.AbstractCollection.addAll(AbstractCollection.java:344)
        //       at java.util.HashSet.<init>(HashSet.java:120)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingHistory.getDistinctEventsByCompletionTime(HandlingHistory.java:36)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingHistory.getMostRecentlyCompletedEvent(HandlingHistory.java:44)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:117)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        Cargo cargo1 = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        handlingEventList.add(
                new HandlingEvent(cargo1, completionTime, registrationTime, HandlingEvent.Type.LOAD, location, new Voyage()));
        cargo.deriveDeliveryProgress(new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.hashCode(Cargo.java:186)
        //       at org.apache.commons.lang3.builder.HashCodeBuilder.append(HashCodeBuilder.java:848)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingEvent.hashCode(HandlingEvent.java:228)
        //       at java.util.HashMap.hash(HashMap.java:340)
        //       at java.util.HashMap.put(HashMap.java:613)
        //       at java.util.HashSet.add(HashSet.java:220)
        //       at java.util.AbstractCollection.addAll(AbstractCollection.java:344)
        //       at java.util.HashSet.<init>(HashSet.java:120)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingHistory.getDistinctEventsByCompletionTime(HandlingHistory.java:36)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingHistory.getMostRecentlyCompletedEvent(HandlingHistory.java:44)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:117)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        handlingEventList.add(new HandlingEvent());
        handlingEventList.add(new HandlingEvent());
        Cargo cargo1 = new Cargo();
        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        handlingEventList.add(
                new HandlingEvent(cargo1, completionTime, registrationTime, HandlingEvent.Type.LOAD, location, new Voyage()));
        cargo.deriveDeliveryProgress(new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.cargo.TrackingId.hashCode(TrackingId.java:47)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.hashCode(Cargo.java:186)
        //       at org.apache.commons.lang3.builder.HashCodeBuilder.append(HashCodeBuilder.java:848)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingEvent.hashCode(HandlingEvent.java:228)
        //       at java.util.HashMap.hash(HashMap.java:340)
        //       at java.util.HashMap.put(HashMap.java:613)
        //       at java.util.HashSet.add(HashSet.java:220)
        //       at java.util.AbstractCollection.addAll(AbstractCollection.java:344)
        //       at java.util.HashSet.<init>(HashSet.java:120)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingHistory.getDistinctEventsByCompletionTime(HandlingHistory.java:36)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingHistory.getMostRecentlyCompletedEvent(HandlingHistory.java:44)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:117)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        TrackingId trackingId1 = new TrackingId();
        Cargo cargo1 = new Cargo(trackingId1, new RouteSpecification());

        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        handlingEventList.add(
                new HandlingEvent(cargo1, completionTime, registrationTime, HandlingEvent.Type.LOAD, location, new Voyage()));
        cargo.deriveDeliveryProgress(new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Cargo#deriveDeliveryProgress(HandlingHistory)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeriveDeliveryProgress10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.eclipse.cargotracker.domain.model.voyage.Voyage.hashCode(Voyage.java:59)
        //       at org.apache.commons.lang3.builder.HashCodeBuilder.append(HashCodeBuilder.java:848)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingEvent.hashCode(HandlingEvent.java:229)
        //       at java.util.HashMap.hash(HashMap.java:340)
        //       at java.util.HashMap.put(HashMap.java:613)
        //       at java.util.HashSet.add(HashSet.java:220)
        //       at java.util.AbstractCollection.addAll(AbstractCollection.java:344)
        //       at java.util.HashSet.<init>(HashSet.java:120)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingHistory.getDistinctEventsByCompletionTime(HandlingHistory.java:36)
        //       at org.eclipse.cargotracker.domain.model.handling.HandlingHistory.getMostRecentlyCompletedEvent(HandlingHistory.java:44)
        //       at org.eclipse.cargotracker.domain.model.cargo.Delivery.derivedFrom(Delivery.java:117)
        //       at org.eclipse.cargotracker.domain.model.cargo.Cargo.deriveDeliveryProgress(Cargo.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        TrackingId trackingId = new TrackingId();
        Cargo cargo = new Cargo(trackingId, new RouteSpecification());

        ArrayList<HandlingEvent> handlingEventList = new ArrayList<>();
        TrackingId trackingId1 = new TrackingId("42");
        Cargo cargo1 = new Cargo(trackingId1, new RouteSpecification());

        LocalDateTime completionTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime registrationTime = LocalDateTime.of(1, 1, 1, 1, 1);
        Location location = new Location();
        handlingEventList.add(
                new HandlingEvent(cargo1, completionTime, registrationTime, HandlingEvent.Type.LOAD, location, new Voyage()));
        cargo.deriveDeliveryProgress(new HandlingHistory(handlingEventList));
    }

    /**
     * Method under test: {@link Cargo#equals(Object)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEquals() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        Cargo cargo = new Cargo();
        cargo.deriveDeliveryProgress(new HandlingHistory(new ArrayList<>()));
        cargo.setOrigin(new Location());
        cargo.equals(null);
    }

    /**
     * Method under test: {@link Cargo#equals(Object)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEquals2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        Cargo cargo = new Cargo();
        cargo.deriveDeliveryProgress(new HandlingHistory(new ArrayList<>()));
        cargo.setOrigin(new Location());
        cargo.equals("Different type to Cargo");
    }

    /**
     * Method under test: {@link Cargo#equals(Object)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEquals3() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        Cargo cargo = new Cargo();
        cargo.deriveDeliveryProgress(new HandlingHistory(new ArrayList<>()));
        cargo.setOrigin(new Location());
        cargo.equals(cargo);
    }
}

