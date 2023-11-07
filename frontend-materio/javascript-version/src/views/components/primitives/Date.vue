<template>
    <div>
        <div v-if="editMode">
            <v-text-field
                v-bind="attrs"
                v-model="date"
                :label="label"
                prepend-icon="mdi-calendar"
                readonly
                v-on="on"
            ></v-text-field>
            <VDatePicker
                    v-model="date"
                    no-title
                    scrollable
            >
                <v-spacer></v-spacer>
                <v-btn text color="primary" @click="resetDate()">
                    Reset
                </v-btn>
                <v-btn text color="primary" @click="setDate(date)">
                    OK
                </v-btn>
            </VDatePicker>
        </div>
        <div v-else>
            {{label}} :  {{value}}
        </div>
    </div>
</template>

<script>
import { VDatePicker } from 'vuetify/lib/labs/components.mjs'
    export default {
        name: 'Date',
        components:{
            VDatePicker
        },
        props: {
            modelValue: Object,
            editMode: Boolean,
            label: String,
        },
        data: () => ({
            menu: false,
            date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
        }),
        created() {
            if(!this.modelValue) {
                this.date = null;
                this.value = this.date;
            }
        },
        mounted() {
        },
        watch: {
            value() {
                this.change();
            }
        },
        methods:{
            change(){
                this.$emit("update:modelValue", this.value);
            },
            resetDate(){
                this.date = null;
                this.value = this.date
                this.setDate(this.value)
            },
            setDate(date){
                this.$refs.menu.save(date)
                this.$emit("update:modelValue", date);
            }
        }
    }
</script>