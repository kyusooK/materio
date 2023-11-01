<template>
    <div style="margin: 0 -15px 0 -15px;">
        <v-card-title>
            {{label}}
        </v-card-title>
        <v-card-text v-if="payment">
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="PaymentType" v-model="payment.paymentType"/>
            </div>
            <div v-else>
                PaymentType :  {{payment.paymentType }}
            </div>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field type="number" label="Amount" v-model="payment.amount"/>
            </div>
            <div v-else>
                Amount :  {{payment.amount }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name:"Payment",
        props: {
            editMode: Boolean,
            modelValue : Object,
            label : String,
        },
        data: () => ({
            payment:{}
        }),
        created(){
            this.payment = this.modelValue
            if(!this.payment) {
                this.payment = {
                    'paymentType': '',
                    'amount': 0,
                };
            }
        },
        watch: {
            payment(newVal) {
                this.$emit('update:modelValue', newVal);
            },
        },
    }
</script>

<style scoped>
</style>