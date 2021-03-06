/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package org.fretron.person.model;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class Person extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Person\",\"namespace\":\"org.fretron.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"age\",\"type\":\"int\"},{\"name\":\"address\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"currentWealth\",\"type\":\"double\",\"default\":0},{\"name\":\"lastUpdate\",\"type\":{\"type\":\"long\",\"logicalType\":\"utc-to-epoch-millis\"}}]}");
    private static final long serialVersionUID = -3039127329167309872L;
    private static final org.apache.avro.Conversion<?>[] conversions =
            new org.apache.avro.Conversion<?>[]{
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            };
    private static SpecificData MODEL$ = new SpecificData();

    private static final BinaryMessageEncoder<Person> ENCODER =
            new BinaryMessageEncoder<Person>(MODEL$, SCHEMA$);

    private static final BinaryMessageDecoder<Person> DECODER =
            new BinaryMessageDecoder<Person>(MODEL$, SCHEMA$);
    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<Person>
            WRITER$ = (org.apache.avro.io.DatumWriter<Person>) MODEL$.createDatumWriter(SCHEMA$);
    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<Person>
            READER$ = (org.apache.avro.io.DatumReader<Person>) MODEL$.createDatumReader(SCHEMA$);
    private java.lang.CharSequence id;
    private java.lang.CharSequence name;
    private int age;
    private java.lang.CharSequence address;
    private double currentWealth;
    private long lastUpdate;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public Person() {
    }

    /**
     * All-args constructor.
     *
     * @param id            The new value for id
     * @param name          The new value for name
     * @param age           The new value for age
     * @param address       The new value for address
     * @param currentWealth The new value for currentWealth
     * @param lastUpdate    The new value for lastUpdate
     */
    public Person(java.lang.CharSequence id, java.lang.CharSequence name, java.lang.Integer age, java.lang.CharSequence address, java.lang.Double currentWealth, java.lang.Long lastUpdate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.currentWealth = currentWealth;
        this.lastUpdate = lastUpdate;
    }

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    /**
     * Return the BinaryMessageEncoder instance used by this class.
     *
     * @return the message encoder used by this class
     */
    public static BinaryMessageEncoder<Person> getEncoder() {
        return ENCODER;
    }

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     *
     * @return the message decoder used by this class
     */
    public static BinaryMessageDecoder<Person> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     *
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
     */
    public static BinaryMessageDecoder<Person> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<Person>(MODEL$, SCHEMA$, resolver);
    }

    /**
     * Deserializes a Person from a ByteBuffer.
     *
     * @param b a byte buffer holding serialized data for an instance of this class
     * @return a Person instance decoded from the given buffer
     * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
     */
    public static Person fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    /**
     * Creates a new Person RecordBuilder.
     *
     * @return A new Person RecordBuilder
     */
    public static Person.Builder newBuilder() {
        return new Person.Builder();
    }

    /**
     * Creates a new Person RecordBuilder by copying an existing Builder.
     *
     * @param other The existing builder to copy.
     * @return A new Person RecordBuilder
     */
    public static Person.Builder newBuilder(Person.Builder other) {
        if (other == null) {
            return new Person.Builder();
        } else {
            return new Person.Builder(other);
        }
    }

    /**
     * Creates a new Person RecordBuilder by copying an existing Person instance.
     *
     * @param other The existing instance to copy.
     * @return A new Person RecordBuilder
     */
    public static Person.Builder newBuilder(Person other) {
        if (other == null) {
            return new Person.Builder();
        } else {
            return new Person.Builder(other);
        }
    }

    /**
     * Serializes this Person to a ByteBuffer.
     *
     * @return a buffer holding the serialized data for this instance
     * @throws java.io.IOException if this instance could not be serialized
     */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    public org.apache.avro.specific.SpecificData getSpecificData() {
        return MODEL$;
    }

    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    public java.lang.Object get(int field$) {
        switch (field$) {
            case 0:
                return id;
            case 1:
                return name;
            case 2:
                return age;
            case 3:
                return address;
            case 4:
                return currentWealth;
            case 5:
                return lastUpdate;
            default:
                throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    @Override
    public org.apache.avro.Conversion<?> getConversion(int field) {
        return conversions[field];
    }

    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value = "unchecked")
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0:
                id = (java.lang.CharSequence) value$;
                break;
            case 1:
                name = (java.lang.CharSequence) value$;
                break;
            case 2:
                age = (java.lang.Integer) value$;
                break;
            case 3:
                address = (java.lang.CharSequence) value$;
                break;
            case 4:
                currentWealth = (java.lang.Double) value$;
                break;
            case 5:
                lastUpdate = (java.lang.Long) value$;
                break;
            default:
                throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    /**
     * Gets the value of the 'id' field.
     *
     * @return The value of the 'id' field.
     */
    public java.lang.CharSequence getId() {
        return id;
    }

    /**
     * Sets the value of the 'id' field.
     *
     * @param value the value to set.
     */
    public void setId(java.lang.CharSequence value) {
        this.id = value;
    }

    /**
     * Gets the value of the 'name' field.
     *
     * @return The value of the 'name' field.
     */
    public java.lang.CharSequence getName() {
        return name;
    }

    /**
     * Sets the value of the 'name' field.
     *
     * @param value the value to set.
     */
    public void setName(java.lang.CharSequence value) {
        this.name = value;
    }

    /**
     * Gets the value of the 'age' field.
     *
     * @return The value of the 'age' field.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the 'age' field.
     *
     * @param value the value to set.
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the 'address' field.
     *
     * @return The value of the 'address' field.
     */
    public java.lang.CharSequence getAddress() {
        return address;
    }

    /**
     * Sets the value of the 'address' field.
     *
     * @param value the value to set.
     */
    public void setAddress(java.lang.CharSequence value) {
        this.address = value;
    }

    /**
     * Gets the value of the 'currentWealth' field.
     *
     * @return The value of the 'currentWealth' field.
     */
    public double getCurrentWealth() {
        return currentWealth;
    }

    /**
     * Sets the value of the 'currentWealth' field.
     *
     * @param value the value to set.
     */
    public void setCurrentWealth(double value) {
        this.currentWealth = value;
    }

    /**
     * Gets the value of the 'lastUpdate' field.
     *
     * @return The value of the 'lastUpdate' field.
     */
    public long getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets the value of the 'lastUpdate' field.
     *
     * @param value the value to set.
     */
    public void setLastUpdate(long value) {
        this.lastUpdate = value;
    }

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    /**
     * RecordBuilder for Person instances.
     */
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Person>
            implements org.apache.avro.data.RecordBuilder<Person> {

        private java.lang.CharSequence id;
        private java.lang.CharSequence name;
        private int age;
        private java.lang.CharSequence address;
        private double currentWealth;
        private long lastUpdate;

        /**
         * Creates a new Builder
         */
        private Builder() {
            super(SCHEMA$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         *
         * @param other The existing Builder to copy.
         */
        private Builder(Person.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.id)) {
                this.id = data().deepCopy(fields()[0].schema(), other.id);
                fieldSetFlags()[0] = other.fieldSetFlags()[0];
            }
            if (isValidValue(fields()[1], other.name)) {
                this.name = data().deepCopy(fields()[1].schema(), other.name);
                fieldSetFlags()[1] = other.fieldSetFlags()[1];
            }
            if (isValidValue(fields()[2], other.age)) {
                this.age = data().deepCopy(fields()[2].schema(), other.age);
                fieldSetFlags()[2] = other.fieldSetFlags()[2];
            }
            if (isValidValue(fields()[3], other.address)) {
                this.address = data().deepCopy(fields()[3].schema(), other.address);
                fieldSetFlags()[3] = other.fieldSetFlags()[3];
            }
            if (isValidValue(fields()[4], other.currentWealth)) {
                this.currentWealth = data().deepCopy(fields()[4].schema(), other.currentWealth);
                fieldSetFlags()[4] = other.fieldSetFlags()[4];
            }
            if (isValidValue(fields()[5], other.lastUpdate)) {
                this.lastUpdate = data().deepCopy(fields()[5].schema(), other.lastUpdate);
                fieldSetFlags()[5] = other.fieldSetFlags()[5];
            }
        }

        /**
         * Creates a Builder by copying an existing Person instance
         *
         * @param other The existing instance to copy.
         */
        private Builder(Person other) {
            super(SCHEMA$);
            if (isValidValue(fields()[0], other.id)) {
                this.id = data().deepCopy(fields()[0].schema(), other.id);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.name)) {
                this.name = data().deepCopy(fields()[1].schema(), other.name);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.age)) {
                this.age = data().deepCopy(fields()[2].schema(), other.age);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.address)) {
                this.address = data().deepCopy(fields()[3].schema(), other.address);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.currentWealth)) {
                this.currentWealth = data().deepCopy(fields()[4].schema(), other.currentWealth);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.lastUpdate)) {
                this.lastUpdate = data().deepCopy(fields()[5].schema(), other.lastUpdate);
                fieldSetFlags()[5] = true;
            }
        }

        /**
         * Gets the value of the 'id' field.
         *
         * @return The value.
         */
        public java.lang.CharSequence getId() {
            return id;
        }


        /**
         * Sets the value of the 'id' field.
         *
         * @param value The value of 'id'.
         * @return This builder.
         */
        public Person.Builder setId(java.lang.CharSequence value) {
            validate(fields()[0], value);
            this.id = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'id' field has been set.
         *
         * @return True if the 'id' field has been set, false otherwise.
         */
        public boolean hasId() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'id' field.
         *
         * @return This builder.
         */
        public Person.Builder clearId() {
            id = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'name' field.
         *
         * @return The value.
         */
        public java.lang.CharSequence getName() {
            return name;
        }


        /**
         * Sets the value of the 'name' field.
         *
         * @param value The value of 'name'.
         * @return This builder.
         */
        public Person.Builder setName(java.lang.CharSequence value) {
            validate(fields()[1], value);
            this.name = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'name' field has been set.
         *
         * @return True if the 'name' field has been set, false otherwise.
         */
        public boolean hasName() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'name' field.
         *
         * @return This builder.
         */
        public Person.Builder clearName() {
            name = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'age' field.
         *
         * @return The value.
         */
        public int getAge() {
            return age;
        }


        /**
         * Sets the value of the 'age' field.
         *
         * @param value The value of 'age'.
         * @return This builder.
         */
        public Person.Builder setAge(int value) {
            validate(fields()[2], value);
            this.age = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'age' field has been set.
         *
         * @return True if the 'age' field has been set, false otherwise.
         */
        public boolean hasAge() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'age' field.
         *
         * @return This builder.
         */
        public Person.Builder clearAge() {
            fieldSetFlags()[2] = false;
            return this;
        }

        /**
         * Gets the value of the 'address' field.
         *
         * @return The value.
         */
        public java.lang.CharSequence getAddress() {
            return address;
        }


        /**
         * Sets the value of the 'address' field.
         *
         * @param value The value of 'address'.
         * @return This builder.
         */
        public Person.Builder setAddress(java.lang.CharSequence value) {
            validate(fields()[3], value);
            this.address = value;
            fieldSetFlags()[3] = true;
            return this;
        }

        /**
         * Checks whether the 'address' field has been set.
         *
         * @return True if the 'address' field has been set, false otherwise.
         */
        public boolean hasAddress() {
            return fieldSetFlags()[3];
        }


        /**
         * Clears the value of the 'address' field.
         *
         * @return This builder.
         */
        public Person.Builder clearAddress() {
            address = null;
            fieldSetFlags()[3] = false;
            return this;
        }

        /**
         * Gets the value of the 'currentWealth' field.
         *
         * @return The value.
         */
        public double getCurrentWealth() {
            return currentWealth;
        }


        /**
         * Sets the value of the 'currentWealth' field.
         *
         * @param value The value of 'currentWealth'.
         * @return This builder.
         */
        public Person.Builder setCurrentWealth(double value) {
            validate(fields()[4], value);
            this.currentWealth = value;
            fieldSetFlags()[4] = true;
            return this;
        }

        /**
         * Checks whether the 'currentWealth' field has been set.
         *
         * @return True if the 'currentWealth' field has been set, false otherwise.
         */
        public boolean hasCurrentWealth() {
            return fieldSetFlags()[4];
        }


        /**
         * Clears the value of the 'currentWealth' field.
         *
         * @return This builder.
         */
        public Person.Builder clearCurrentWealth() {
            fieldSetFlags()[4] = false;
            return this;
        }

        /**
         * Gets the value of the 'lastUpdate' field.
         *
         * @return The value.
         */
        public long getLastUpdate() {
            return lastUpdate;
        }


        /**
         * Sets the value of the 'lastUpdate' field.
         *
         * @param value The value of 'lastUpdate'.
         * @return This builder.
         */
        public Person.Builder setLastUpdate(long value) {
            validate(fields()[5], value);
            this.lastUpdate = value;
            fieldSetFlags()[5] = true;
            return this;
        }

        /**
         * Checks whether the 'lastUpdate' field has been set.
         *
         * @return True if the 'lastUpdate' field has been set, false otherwise.
         */
        public boolean hasLastUpdate() {
            return fieldSetFlags()[5];
        }


        /**
         * Clears the value of the 'lastUpdate' field.
         *
         * @return This builder.
         */
        public Person.Builder clearLastUpdate() {
            fieldSetFlags()[5] = false;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Person build() {
            try {
                Person record = new Person();
                record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
                record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
                record.age = fieldSetFlags()[2] ? this.age : (java.lang.Integer) defaultValue(fields()[2]);
                record.address = fieldSetFlags()[3] ? this.address : (java.lang.CharSequence) defaultValue(fields()[3]);
                record.currentWealth = fieldSetFlags()[4] ? this.currentWealth : (java.lang.Double) defaultValue(fields()[4]);
                record.lastUpdate = fieldSetFlags()[5] ? this.lastUpdate : (java.lang.Long) defaultValue(fields()[5]);
                return record;
            } catch (org.apache.avro.AvroMissingFieldException e) {
                throw e;
            } catch (java.lang.Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

}










